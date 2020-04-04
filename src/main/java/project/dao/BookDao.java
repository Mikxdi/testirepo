package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project.database.Database;
import project.domain.Book;
import project.domain.Tip;

/**
 *
 * @author chenhuiz
 */
public class BookDao {

    private Connection conn;

    public BookDao(Database db) throws SQLException {
        this.conn = db.getConnection();
    }

    public List<Tip> listAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Book");

            List<Tip> books = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                String ISBN = result.getString("ISBN");
                String description = result.getString("description");
                String url = result.getString("url");
                boolean checked = result.getBoolean("checked");

                Tip book = new Book(id, title, author, ISBN, description, url, checked);
                books.add(book);
            }

            return books;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(String title, String author, String ISBN, String description, String url) {
        System.out.println("Lisäys");
        if (title.isEmpty() || author.isEmpty() || ISBN.isEmpty() || description.isEmpty() || url.isEmpty()) {
            return;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Book (title, author, ISBN, description, url, checked) "
                    + "VALUES (?, ?, ?, ?, ?, false)");
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, ISBN);
            stmt.setString(4, description);
            stmt.setString(5, url);

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean markAsRead(String title) {
        
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Book SET checked = ? WHERE title = ? ");

            stmt.setBoolean(1, true);
            stmt.setString(2, title);
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

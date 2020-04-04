package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project.database.Database;
import project.domain.Tip;
import project.domain.Video;

/**
 *
 * @author chenhuiz
 */
public class VideoDao {
    
    private Connection conn;

    public VideoDao(Database db) throws SQLException {
        this.conn = db.getConnection();
    }

    public List<Tip> listAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Video");

            List<Tip> videos = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                String description = result.getString("description");
                String url = result.getString("url");
                boolean checked = result.getBoolean("checked");

                Tip video = new Video(id, title, author, description, url, checked);
                videos.add(video);
            }

            return videos;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(String title, String author, String description, String url) {
        if (title.isEmpty() || author.isEmpty() || description.isEmpty() || url.isEmpty()) {
            return;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Video (title, author, description, url, checked) "
                    + "VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, description);
            stmt.setString(4, url);
            if(System.getenv("JDBC_DATABASE_URL")== null){
                int value = 0;
                stmt.setInt(5, value);
            }else{
                stmt.setBoolean(5, false);
            }

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean markAsRead(String title) {
        
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Video SET checked = ? WHERE title = ? ");

            stmt.setBoolean(1, true);
            stmt.setString(2, title);
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

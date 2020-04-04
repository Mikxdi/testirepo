package project.domain;

/**
 *
 * @author chenhuiz
 */
public class Book extends Tip {
    private String ISBN;
    private final String type;
    
    public Book(int id, String title, String author, String ISBN, String description, String url, boolean checked) {
        super(id, title, author, description, url, checked);
        this.ISBN = ISBN;
        this.type = "Kirja";
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "\nTitle: " + this.getTitle() + 
                "\nAuthor: " + this.getAuthor() +
                "\nISBN: " + this.getISBN() + 
                "\nDescription: " + this.getDescription() +
                "\nUrl: " + this.getUrl() +
                "\nChecked: " + this.getChecked() + 
                "\nType: " + type;
    }
}

package project.domain;

/**
 *
 * @author chenhuiz
 */
public class Video extends Tip {
    
    private final String type;
    
    public Video(int id, String title, String author, String description, String url, boolean checked) {
        super(id, title, author, description, url, checked);
        this.type = "Video";
    }
    
    public String getType() {
        return this.type;
    }
    
    public String toString() {
        return "\nTitle: " + this.getTitle() + 
                "\nAuthor: " + this.getAuthor() +
                "\nDescription: " + this.getDescription() +
                "\nUrl: " + this.getUrl() +
                "\nChecked: " + this.getChecked() + 
                "\nType: " + type;
    }
    
}

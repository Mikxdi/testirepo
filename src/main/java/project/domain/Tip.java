package project.domain;

/**
 *
 * @author chenhuiz
 */
public abstract class Tip {
    private int id;
    private String title;
    private String author;
    private String description;
    private String url;
    private boolean checked;
    
    public Tip(int id, String title, String author, String description, String url, boolean checked) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
        this.checked = checked;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public boolean getChecked() {
        return checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    @Override
    public String toString() {
        return "\nTitle: " + title + 
                "\nAuthor: " + author +
                "\nDescription: " + description +
                "\nUrl: " + url +
                "\nChecked: " + checked;
    }
}

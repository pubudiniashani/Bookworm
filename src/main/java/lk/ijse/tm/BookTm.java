package lk.ijse.tm;

public class BookTm {

    private String title;
    private String author;
    private String category;
    private  String availability;

    public BookTm(String title, String author, String category, String availability) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}

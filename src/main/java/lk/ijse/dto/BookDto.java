package lk.ijse.dto;

public class BookDto {

    private int bookId;
    private String title;
    private String author;
    private String category;
    private  String availability;
    private int branchId;

    public BookDto(int bookId, String title, String author, String category, String availability, int branchId) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availability = availability;
        this.branchId = branchId;
    }

    public BookDto(String title, String author, String category, String availability, int branchId) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.availability = availability;
        this.branchId = branchId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", availability='" + availability + '\'' +
                ", branchId=" + branchId +
                '}';
    }
}

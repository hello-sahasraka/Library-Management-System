public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String yearPublished;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getYearPublished() {
        return yearPublished;
    }

    public void setId(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) {this.author = author;}
    public void setPublisher(String publisher) {this.publisher = publisher;}
    public void setYearPublished(String yearPublished) {this.yearPublished = yearPublished;}
}

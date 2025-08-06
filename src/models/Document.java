package models;

public class Document {
    private String title;
    private String author;
    private String publicationDate;
    private String publisher;
    private String language;
    private int pages;
    private String id;
    private int Quantity;

    public Document() {}
    
    // Constructor
    public Document(String title, String author, String publicationDate, String publisher, String language, int pages, String id, int quantity) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.language = language;
        this.pages = pages;
        this.id = id;
        this.Quantity = quantity;
    }

    public Document(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publisher = "Unknown";
        this.language = "Unknown";
        this.pages = 0;
        this.id = "";
        this.Quantity = 0;
        if (publicationDate == null) {
            this.publicationDate = "N/A";
        } else {
            this.publicationDate = publicationDate;
        }
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}
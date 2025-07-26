package models;

public class Document {
    private String title;
    private String author;
    private String publicationDate;
    private String publisher;
    private String language;
    private int pages;
    private String abstractOrSummary;
    private String keywords;

    // Constructor
    public Document(String title, String author, String publicationDate, String publisher, String language, String isbnOrIdentifier, int pages, String abstractOrSummary, String keywords) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.language = language;
        this.pages = pages;
        this.abstractOrSummary = abstractOrSummary;
        this.keywords = keywords;
    }

    public Document(String title, String author, String publicationDate) {
        this.title = title;
        this.author = author;
        this.publisher = "Unknown";
        this.language = "Unknown";
        this.pages = 0;
        this.abstractOrSummary = "No summary available";
        this.keywords = "None";
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

    public String getAbstractOrSummary() {
        return abstractOrSummary;
    }

    public void setAbstractOrSummary(String abstractOrSummary) {
        this.abstractOrSummary = abstractOrSummary;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

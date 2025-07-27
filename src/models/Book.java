package models;

<<<<<<< HEAD
public class Book {
    
=======
public class Book extends Document {
    private String genre;
    private String format;
    private String isbnOrIdentifier;

    // Constructor
    public Book(String title, String author, String publicationDate, String publisher, String language, String isbnOrIdentifier, int pages, String abstractOrSummary, String keywords, String genre, String format) {
        super(title, author, publicationDate, publisher, language, format, pages, abstractOrSummary, keywords);
        this.genre = genre;
        this.format = format;
        this.isbnOrIdentifier = isbnOrIdentifier;
    }

    // Getters
    public String getGenre() {
        return genre;
    }

    public String getFormat() {
        return format;
    }
    
    public String getIsbnOrIdentifier() {
        return isbnOrIdentifier;
    }

    public void setIsbnOrIdentifier(String isbnOrIdentifier) {
        this.isbnOrIdentifier = isbnOrIdentifier;
    }

    // Setters
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setFormat(String format) {
        this.format = format;
    }
>>>>>>> edd18aa5ed8ec2e418302875afd4483d58c42a44
}

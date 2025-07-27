package models;

public class Thesis extends Document {
    private String university;
    private String degree;
    private String advisor;
    private String fieldOfStudy;

    // Constructor
    public Thesis(String title, String author, String publicationDate, String publisher, String language, String isbnOrIdentifier, int pages, String abstractOrSummary, String keywords, String university, String degree, String advisor, String fieldOfStudy) {
        super(title, author, publicationDate, publisher, language, isbnOrIdentifier, pages, abstractOrSummary, keywords);
        this.university = university;
        this.degree = degree;
        this.advisor = advisor;
        this.fieldOfStudy = fieldOfStudy;
    }

    // Getters and Setters
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }
    
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
}

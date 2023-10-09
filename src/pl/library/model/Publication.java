package pl.library.model;

abstract class Publication {
    private String title;
    private int year;
    private String publisher;

    public Publication(String title,  int releaseDate, String publisher) {
        this.title = title;
        this.year = releaseDate;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    abstract public void printInfo();
}

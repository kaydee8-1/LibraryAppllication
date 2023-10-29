package pl.library.model;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.time.Year;

public abstract class Publication {
    private String title;
    private int year;
    private String publisher;
    private Calendar cal = Calendar.getInstance();
    int currentYear = cal.get(Calendar.YEAR);

    public Publication(String title,  int releaseDate, String publisher) {
        this.title = title;
        setYear(releaseDate);
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
        if (year < 0 || year > currentYear)
            throw new ArgumentOutsideRangeException("Year", 0, currentYear);
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

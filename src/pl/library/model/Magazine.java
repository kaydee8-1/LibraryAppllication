package pl.library.model;

import java.util.InputMismatchException;
import java.util.Objects;

public class Magazine extends Publication{
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, String language,  int year, int month, int day) {
        super(title, year, publisher);
        this.language = language;
        setMonth(month);
        setDay(day);
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new ArgumentOutsideRangeException("Month", 1, 12);
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new ArgumentOutsideRangeException("Day", 1, 31);
        }
        this.day = day;
    }

    public String toString() {
        return getClass().getSimpleName()+ ": " + getTitle() + "; " + getPublisher() + "; " + getYear() + "; " +
                month + "; " + day + ";" + language;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return month == magazine.month && day == magazine.day && Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), month, day, language);
    }
}

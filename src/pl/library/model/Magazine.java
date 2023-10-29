package pl.library.model;

import java.util.InputMismatchException;

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

    @Override
    public void printInfo() {
        String info = getClass().getSimpleName()+ ": " + getTitle() + "; " + getPublisher() + "; " + getYear() + "; " +
                month + "; " + day + ";" + language;
        System.out.println(info);
    }
}

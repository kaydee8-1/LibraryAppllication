package pl.library.model;

public class Magazine extends Publication{
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, String language,  int year, int month, int day) {
        super(title, year, publisher);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    @Override
    public void printInfo() {
        String info = getClass().getSimpleName()+ ": " + getTitle() + "; " + getPublisher() + "; " + getYear() + "; " +
                month + "; " + day + ";" + language;
        System.out.println(info);
    }
}

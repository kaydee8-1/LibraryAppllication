package pl.library.model;

public class Book extends Publication {
    private String author;
    private int pages;
    private String isbn;

    public static int counter = 0;

    public Book(String title, String author, int year, int pages, String publisher, String isbn) {
        super(title, year, publisher);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        counter++;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void printInfo() {
        String info = getClass().getSimpleName()+ ": " + getTitle() + "; " + author  + "; " + getYear() + "; " + pages + "; " +
                super.getPublisher();
        if (isbn != null) {
            info += "; " + isbn;
        }
        System.out.println(info);
    }
}

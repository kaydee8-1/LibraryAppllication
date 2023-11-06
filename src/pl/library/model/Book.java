package pl.library.model;

import java.util.Objects;

public class Book extends Publication {
    private String author;
    private int pages;
    private String isbn;

    public static int counter = 0;

    public Book(String title, String author, int year, int pages, String publisher, String isbn) {
        super(title, year, publisher);
        this.author = author;
        setPages(pages);
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
        if (pages < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.pages = pages;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        String info = getClass().getSimpleName()+ ": " + getTitle() + "; " + author  + "; " + getYear() + "; " + pages + "; " +
                super.getPublisher();
        if (isbn != null) {
            info += "; " + isbn;
        }
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }
}

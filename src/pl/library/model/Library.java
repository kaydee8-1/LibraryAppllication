package pl.library.logic;

import pl.library.io.DataReader;
import pl.library.model.Book;

public class Library {

    private final int maxBooks = 1000;
    private Book[] books = new Book[maxBooks];
    private int bookCounter = 0;

    public void addBook(Book book){
        if (bookCounter < maxBooks) {
            books[bookCounter] = book;
            bookCounter++;
        }
        else System.out.println("Maksymalna liczba książek osiągnięta");
    }

    public void printAll() {
        if (bookCounter == 0)
            System.out.println("Nie dodano żadnych książek");

        else {
            for(int i=0; i<bookCounter; ++i) {
                books[i].printInfo();
            }
        }
    }
}

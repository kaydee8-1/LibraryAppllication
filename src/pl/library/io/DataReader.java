package pl.library.io;
import java.util.Scanner;

import pl.library.logic.Option;
import pl.library.model.Book;
import pl.library.model.Magazine;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public Book readAndCreateBook() {
        System.out.println("Tytuł: ");
        String title = scanner.nextLine();

        System.out.println("Autor: ");
        String author = scanner.nextLine();

        System.out.println("Wydawnictwo: ");
        String publisher = scanner.nextLine();

        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.println("Rok wydania: ");
        int releaseDate = getInt();

        System.out.println("Ilość stron: ");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytuł: ");
        String title = scanner.nextLine();

        System.out.println("Wydawnictwo: ");
        String publisher = scanner.nextLine();

        System.out.println("Rok wydania: ");
        int year = getInt();

        System.out.println("Miesiąc wydania: ");
        int month = getInt();

        System.out.println("Dzień wydania: ");
        int day = getInt();

        System.out.println("Język wydania: ");
        String language= scanner.nextLine();


        return new Magazine(title, publisher, language, year, month, day);
    }

    public int getInt() {
        int intNumber = scanner.nextInt();
        scanner.nextLine();
        return intNumber;
    }

    public int getOption() {
        int userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }

    public void close() {
        scanner.close();
    }
}

package pl.library.io;
import java.util.InputMismatchException;
import java.util.Scanner;

import pl.library.model.Book;
import pl.library.model.Magazine;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter consolePrinter;

    public DataReader(ConsolePrinter printer) {
        this.consolePrinter = printer;
    }

    public Book readAndCreateBook() {
        consolePrinter.printLine("Tytuł: ");
        String title = scanner.nextLine();

        consolePrinter.printLine("Autor: ");
        String author = scanner.nextLine();

        consolePrinter.printLine("Wydawnictwo: ");
        String publisher = scanner.nextLine();

        consolePrinter.printLine("ISBN: ");
        String isbn = scanner.nextLine();

        consolePrinter.printLine("Rok wydania: ");
        int releaseDate = getInt();

        consolePrinter.printLine("Ilość stron: ");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        consolePrinter.printLine("Tytuł: ");
        String title = scanner.nextLine();

        consolePrinter.printLine("Wydawnictwo: ");
        String publisher = scanner.nextLine();

        consolePrinter.printLine("Rok wydania: ");
        int year = getInt();

        consolePrinter.printLine("Miesiąc wydania: ");
        int month = getInt();

        consolePrinter.printLine("Dzień wydania: ");
        int day = getInt();

        consolePrinter.printLine("Język wydania: ");
        String language = scanner.nextLine();


        return new Magazine(title, publisher, language, year, month, day);
    }

    public int getInt() {
        boolean error = true;
        int intNumber = 0;
        do {
            try {
                intNumber = scanner.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                consolePrinter.printError("Input mismatch");
            }
            finally {
                scanner.nextLine();
            }
        } while (error);

        return intNumber;
    }

    public int getOption() {
        return getInt();

    }

    public void close() {
        scanner.close();
    }
}

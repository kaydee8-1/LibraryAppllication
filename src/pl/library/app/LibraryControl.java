package pl.library.app;

import pl.library.exceptions.NoSuchOptionException;
import pl.library.io.ConsolePrinter;
import pl.library.io.DataReader;
import pl.library.model.ArgumentOutsideRangeException;
import pl.library.model.Library;
import pl.library.model.Book;
import pl.library.model.Magazine;

import java.util.InputMismatchException;

public class LibraryControl {
    private Library library = new Library();
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private DataReader dataReader = new DataReader(consolePrinter);

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();

            switch (option) {
                case EXIT -> exit();
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_MAGAZINES -> printMagazines();
                case PRINT_ALL_PUBLICATIONS -> printAllPublications();
                default -> consolePrinter.printLine("Podana liczba nie pasuje");
            }
        } while (option!= Option.EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję: ");
        for(Option option: Option.values())
            consolePrinter.printLine(option.toString());
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                 option = Option.createFromInt(dataReader.getOption());
                 optionOk = true;
            } catch (NoSuchOptionException e) {
                consolePrinter.printError(e.getMessage());
            }
        }
        return option;
    }


    private void addBook() {
        try {
            Book newBook = dataReader.readAndCreateBook();
            library.addBook(newBook);
        } catch (IllegalArgumentException | InputMismatchException | ArgumentOutsideRangeException e) {
            consolePrinter.printError(e.getMessage() + ". Nie udało się utworzyć książki");
        }
    }

    private  void printBooks() {
        consolePrinter.printAllBooks(library.getPublications());
    }

    private void addMagazine() {
        try {
            Magazine newMagazine = dataReader.readAndCreateMagazine();
            library.addMagazine(newMagazine);
        } catch (InputMismatchException | ArgumentOutsideRangeException e) {
            consolePrinter.printError(e.getMessage() + ". Nie udało się utworzyć magazynu");
        }
    }

    private void printMagazines() {
        consolePrinter.printAllMagazines(library.getPublications());
    }
    private void printAllPublications() {library.printAllPublications();}

    public void exit()
    {
        consolePrinter.printLine("Koniec programu papa");
        dataReader.close();
    }

    public enum Option {
        EXIT(0,"Wyjście z programu"),
        ADD_BOOK(1,"Dodanie nowej książki"),
        ADD_MAGAZINE( 2, "dodanie nowego magazynu"),
        PRINT_BOOKS(3, "wyświetl dostępne książki"),
        PRINT_MAGAZINES(4, "wyświetl dostępne magazyny"),
        PRINT_ALL_PUBLICATIONS(5, "wyświetl wszystkie dostępne publikacje");

        private final int optionNumber;
        private final String description;

        Option(int optionNumber, String description) {
            this.optionNumber = optionNumber;
            this.description = description;
        }

        public int getOptionNumber() {
            return optionNumber;

        }

        public String getDescription() {
            return description;
        }
        public String toString() {
            return getOptionNumber() + " - " + name() + "(" +getDescription() + ")";
        }

        public static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("No option with ID " + option);
            }
        }
    }
}

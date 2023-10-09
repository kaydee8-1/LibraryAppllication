package pl.library.logic;

import pl.library.io.DataReader;
import pl.library.model.Library;
import pl.library.model.Book;
import pl.library.model.Magazine;

public class LibraryControl {
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    private final static int EXIT = 0;
    private final static int ADD_BOOK = 1;
    private final static int ADD_MAGAZINE = 2;
    private final static int PRINT_BOOKS = 3;
    private final static int PRINT_MAGAZINES = 4;


    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();

            switch (option) {
                case EXIT: exit(); break;
                case ADD_BOOK:
                    addBook(); break;
                case PRINT_BOOKS:
                    printBooks(); break;
                case ADD_MAGAZINE:
                    addMagazine(); break;
                case PRINT_MAGAZINES:
                    printMagazines(); break;
                default: System.out.println("Podana liczba nie pasuje");
            }
        } while (option!= EXIT);
    }

    private void addBook() {
        Book newBook = dataReader.readAndCreateBook();
        library.addBook(newBook);
    }

    private  void printBooks() {
        library.printAllBooks();
    }

    private void addMagazine() {
        Magazine newMagazine = dataReader.readAndCreateMagazine();
        library.addMagazine(newMagazine);
    }

    private void printMagazines() {
        library.printAllMagazines();
    }

    public void exit()
    {
        System.out.println("Koniec programu papa");
        dataReader.close();
    }
    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(ADD_MAGAZINE+ " - dodanie nowego magazynu");
        System.out.println(PRINT_BOOKS + " - wyświetl dostępne książki");
        System.out.println(PRINT_MAGAZINES + " - wyświetl dostępne magazyny");
    }
}

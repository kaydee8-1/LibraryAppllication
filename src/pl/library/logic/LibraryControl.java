package pl.library.logic;

import pl.library.io.DataReader;
import pl.library.model.Library;
import pl.library.model.Book;
import pl.library.model.Magazine;

public class LibraryControl {
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getOption());

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
                case PRINT_ALL_PUBLICATIONS:
                    printAllPublications(); break;
                default: System.out.println("Podana liczba nie pasuje");
            }
        } while (option!= Option.EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję: ");
        for(Option option: Option.values())
            System.out.println(option.toString());
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
    private void printAllPublications() {library.printAllPublications();}

    public void exit()
    {
        System.out.println("Koniec programu papa");
        dataReader.close();
    }
}

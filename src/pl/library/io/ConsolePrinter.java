package pl.library.io;

import jdk.swing.interop.SwingInterOpUtils;
import pl.library.model.*;


public class ConsolePrinter {

    public void printLine(String text){
        System.out.println(text);
    }

    public void printError(String text) {
        System.err.println(text);
    }
    public void printAllBooks(Publication[] publications) {
        int countBooks = 0;

        for(Publication p : publications) {
            if (p instanceof Book) {
                printLine(p.toString());
                countBooks++;
            }
        }

        if (countBooks == 0)
            printLine("Nie ma żadnych ksiażek w bibliotece");
    }

    public void printAllMagazines(Publication[] publications) {
        int countMagazines = 0;

        for(Publication p : publications) {
            if (p instanceof Magazine) {
                printLine(p.toString());
                countMagazines++;
            }
        }

        if (countMagazines == 0)
            printLine("Nie ma żanych magazynów w bibliotece");

    }

    public void printAllPublications(Publication[] publications) {
        int countPublications = 0;

        for (Publication publication : publications) {
            printLine(publication.toString());
            countPublications++;
        }

        if (countPublications == 0)
            System.out.println("Nie dodano żadnych ksiązaek ani magazynów");
    }
}

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
                p.printInfo();
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
                p.printInfo();
                countMagazines++;
            }
        }

        if (countMagazines == 0)
            printLine("Nie ma żanych magazynów w bibliotece");

    }
}

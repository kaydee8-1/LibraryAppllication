package pl.library.app;

import pl.library.model.Magazine;
import pl.library.model.Publication;

import java.util.Objects;

public class LibraryApp {
    final static String APP_NAME = "Biblioteka v1.4";
    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}

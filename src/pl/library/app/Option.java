package pl.library.app;

import pl.library.exceptions.NoSuchOptionException;

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

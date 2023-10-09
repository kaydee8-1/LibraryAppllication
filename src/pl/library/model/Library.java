package pl.library.model;

public class Library {

    private final static int MAX_Capacity = 1000;
    private Publication[] publications = new Publication[MAX_Capacity];
    private int capacityCounter = 0;

    public void addBook(Book book){
        if (capacityCounter < MAX_Capacity) {
            publications[capacityCounter] = book;
            capacityCounter++;
        }
        else System.out.println("Maksymalna liczba książek osiągnięta");
    }

    public void printAllBooks() {
        if (capacityCounter == 0)
            System.out.println("Nie dodano żadnych książek");

        else {
            for(int i = 0; i< capacityCounter; ++i) {
                publications[i].printInfo();
            }
        }
    }

    public void addMagazine(Magazine magazine){
        if (capacityCounter < MAX_Capacity) {
            publications[capacityCounter] =magazine;
            capacityCounter++;
        }
        else System.out.println("Maksymalna liczba książek osiągnięta");
    }

    public void printAllMagazines() {
        if (capacityCounter == 0)
            System.out.println("Nie dodano żadnych magazynów");

        else {
            for(int i = 0; i< capacityCounter; ++i) {
                publications[i].printInfo();
            }
        }
    }
}

package pl.library.model;

public class Library {

    private final static int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int capacityCounter = 0;

    public void addBook(Book book){
        if (capacityCounter < MAX_PUBLICATIONS) {
            publications[capacityCounter] = book;
            capacityCounter++;
        }
        else System.out.println("Maksymalna liczba książek osiągnięta");
    }

    public void addMagazine(Magazine magazine){
        if (capacityCounter < MAX_PUBLICATIONS) {
            publications[capacityCounter] = magazine;
            capacityCounter++;
        }
        else System.out.println("Maksymalna liczba książek osiągnięta");
    }

    public void printAllPublications() {
        if (capacityCounter == 0)
            System.out.println("Nie dodano żadnych ksiązaek ani magazynów");

        else {
            for(int i = 0; i< capacityCounter; ++i) {
                publications[i].printInfo();
            }
        }
    }

    public void printAllBooks() {
        int countBooks = 0;

        for(int i = 0; i < capacityCounter; ++i) {
            if (publications[i] instanceof Book) {
                publications[i].printInfo();
                countBooks++;
            }
        }

        if (countBooks == 0)
            System.out.println("Nie ma żadnych ksiażek w bibliotece");
    }

    public void printAllMagazines() {
        int countMagazines = 0;

        for(int i = 0; i < capacityCounter; ++i) {
            if (publications[i] instanceof Magazine) {
                publications[i].printInfo();
                countMagazines++;
            }
        }

        if (countMagazines == 0)
            System.out.println("Nie ma żanych magazynów w bibliotece");

    }
}



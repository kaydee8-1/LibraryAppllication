package pl.library.model;

public class Library {

    private final static int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int capacityCounter = 0;

    public Publication[] getPublications() {
        Publication[] result = new Publication[capacityCounter];
        for (int i = 0; i < capacityCounter; ++i) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addBook(Book book){
        addPublication(book);
    }

    public void addMagazine(Magazine magazine){
        addPublication(magazine);
    }

    private void addPublication(Publication publication) {
        if (capacityCounter >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded " + MAX_PUBLICATIONS);
        }
        publications[capacityCounter] = publication;
        capacityCounter++;
    }

}



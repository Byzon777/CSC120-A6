import java.util.Hashtable;

/**
 * Represents a library - type of building where books are being stored.
 */
public class Library extends Building {
    
    private Hashtable<String, Boolean> collection;

    /**
     * Constructs a new Library object with the given parameters.
     *
     * @param name     The name of the library.
     * @param address  The address of the library.
     * @param nFloors  The number of floors in the library.
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<>();
    }

    /**
     * Adds a book title to the library's collection if it's not already present.
     *
     * @param title The title of the book to add.
     */
    public void addTitle(String title) {
        if (!collection.containsKey(title)) {
            collection.put(title, true);
        } else {
            System.out.println("The title is already in the collection.");
        }
    }

    /**
     * Removes a book title from the library's collection.
     *
     * @param title The title of the book to remove.
     * @return The title of the book removed, or null if the book was not found.
     */
    public String removeTitle(String title) {
        if (collection.remove(title) != null) {
            return title;
        }
        return null;
    }

    /**
     * Checks out a book from the library if it's available.
     *
     * @param title The title of the book to check out.
     */
    public void checkOut(String title) {
        if (collection.containsKey(title)) {
            if (collection.get(title)) {
                collection.put(title, false);
            } else {
                System.out.println("The book is already checked out.");
            }
        } else {
            System.out.println("The book is not in the collection.");
        }
    }

    /**
     * Returns a book to the library if it was checked out.
     *
     * @param title The title of the book to return.
     */
    public void returnBook(String title) {
        if (collection.containsKey(title)) {
            if (!collection.get(title)) {
                collection.put(title, true);
            } else {
                System.out.println("The book is already returned.");
            }
        } else {
            System.out.println("The book is not in the collection.");
        }
    }

    /**
     * Checks if the library contains a specific book title.
     *
     * @param title The title of the book to check.
     * @return true if the book is in the collection, false otherwise.
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Checks if a book is available for checkout.
     *
     * @param title The title of the book to check.
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable(String title) {
        return collection.getOrDefault(title, false);
    }

    /**
     * Prints the library's collection with checkout status.
     */
    public void printCollection() {
        for (String title : collection.keySet()) {
            System.out.println(title + " - Available: " + collection.get(title));
        }
    }
    
}

package syr.edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalog;
    public Library() {
        catalog = new ArrayList<>();
    }

    /*
     * Add book to the catalog
     * Assumption: If any value of book is blank or null or -1, it wont add in the list
     * Param: Book
     * Return: void
     * 
     */
    public void add(Book b) {
        if(b.getAuthor() != "" && b.getAuthor() != null && b.getTitle() != "" && b.getTitle() != null && b.getPublisher() != "" && b.getPublisher() != null && b.getIsbn() != "" && b.getIsbn() != null && b.getYearPublished() != -1 && b.getType() != BookType.ANY){
            catalog.add(b);
        }
    }

    /*
     * Search book from the catalog
     * Assumption: If all value of book is blank or null or -1, it would return blank list
     *             Will compare exact match in case insensitive manner
     * Param: Book
     * Return: List<Book>
     * 
     */
    public List<Book> search(Book lookFor) {
        List<Book> results = new ArrayList<>();
        boolean toAdd = false;
        for (Book curr: catalog) {
            if (lookFor.getAuthor() != null && lookFor.getAuthor() != "") {
                toAdd = true;
                if (!lookFor.getAuthor().equalsIgnoreCase(curr.getAuthor())) {
                    continue;
                }
            }
            if (lookFor.getTitle() != null && lookFor.getTitle() != "") {
                toAdd = true;
                if (!lookFor.getTitle().equalsIgnoreCase(curr.getTitle())) {
                    continue;
                }
            }
            if (lookFor.getPublisher() != null && lookFor.getPublisher() != "") {
                toAdd = true;
                if (!lookFor.getPublisher().equalsIgnoreCase(curr.getPublisher())) {
                    continue;
                }
            }
            if (lookFor.getIsbn() != null && lookFor.getIsbn() != "") {
                toAdd = true;
                if (!lookFor.getIsbn().equalsIgnoreCase(curr.getIsbn())) {
                    continue;
                }
            }
            if (lookFor.getYearPublished() != -1) {
                toAdd = true;
                if (lookFor.getYearPublished() != curr.getYearPublished()) {
                    continue;
                }
            }
            if (lookFor.getType() != BookType.ANY) {
                toAdd = true;
                if (lookFor.getType() != curr.getType()) {
                    continue;
                }
            }
            if (toAdd)
                results.add(curr);
            else
                break;
        }
        return results;
    }

    public static void main(String[] args) {
        Library lib = new Library();
        lib.add(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, BookType.HARDCOVER));
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, BookType.PAPERBACK);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, BookType.EBOOK);
        List<Book> results = lib.search(new Book("", null, null, null, -1, BookType.ANY));
        for (Book b: results) {
            System.out.println(b.toString());
        }
    }
}

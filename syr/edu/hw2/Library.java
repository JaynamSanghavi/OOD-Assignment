package syr.edu.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;


public class Library {
    private List<Book> catalog;

    /*
     * Add the book in catalog
     * Assumption: All field are compulsory, if any one is blank it wont add.
     * Check if any same book exists or not(Case Sensitive).
     * For null: int is 0 and string is "".
     * Param: Book class object
     * Return: Void
     */

    public void add(Book book){
        if(catalog == null){
            catalog = new ArrayList<Book>();
        }
        if(book.getAuthor() != "" && book.getTitle() != "" && book.getPublisher() != "" && book.getIsbn() != "" && book.getYearPublished() != 0){
            int i = 0;
            for (i = 0;i<catalog.size();i++) {
                if(catalog.get(i).equals(book))
                    break;
            }
            if(i == catalog.size())
                catalog.add(book);
        }
    }

    /*
     * Search the book in catalog
     * Assumption: Author, Title and Publisher would be searched as substring case insensitive 
     * Isbn and Year of publication would be exact searched if present.
     * For null: int is 0 and string is "".
     * Param: Book class object
     * Return: List<Book>
     */

    public ArrayList<Book> search(Book book){
        ArrayList<Book> returnList = new ArrayList<Book>();
        for (Book book2 : catalog) {
            if((book2.getAuthor().trim().toLowerCase().contains(book.getAuthor().trim().toLowerCase()))){
                if(book2.getTitle().trim().toLowerCase().contains(book.getTitle().trim().toLowerCase())){
                    if(book2.getPublisher().trim().toLowerCase().contains(book.getPublisher().trim().toLowerCase())){
                        if(book.getIsbn().trim() != ""){
                            if(! book2.getIsbn().trim().toLowerCase().equals(book.getIsbn().trim().toLowerCase())){
                                continue;
                            }
                        }
                        if(book.getYearPublished() != 0){
                            if(book2.getYearPublished() != book.getYearPublished()){
                                continue;
                            }
                        }
                        returnList.add(book2); 
                    }
                }
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
        Book b4 = new Book("", "lear", "", "9781449358624",0);
        Book b5 = new Book("Holden Karau 1", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b6 = new Book("abcd", "", "", " ",0);
        Library l = new Library();
        l.add(b1);
        l.add(b2);
        l.add(b3);
        l.add(b1);
        l.add(b5);
        //l.add(b2);
        // System.out.println(l.search(b4));
        // System.out.println(l.search(b2));
        System.out.println(l.search(b6));
        //System.out.println(l.search(b1));
    }

}

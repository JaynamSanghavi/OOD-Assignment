package syr.edu.hw2;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> catalog;

    /*
     * Add the book in catalog
     * Assumption: All field are compulsory, if any one is blank or null it wont add.
     * Check if any same book exists or not(Case Sensitive).
     * For null: int is 0.
     * Param: Book class
     * Return: Void
     */

    public void add(Book book){
        if(catalog == null){
            catalog = new ArrayList<Book>();
        }
        System.out.println(book.getAuthor());
        if(book.getAuthor() != "" && book.getAuthor() != null && book.getTitle() != "" && book.getTitle() != null && book.getPublisher() != "" && book.getPublisher() != null && book.getIsbn() != "" && book.getIsbn() != null && book.getYearPublished() != 0){
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
     * For null: int is 0.
     * Param: Book class
     * Return: List<Book>
     */

    public List<Book> search(Book book){
        List<Book> returnList = new ArrayList<Book>();
        for (Book book2 : catalog) {
            if(book.getAuthor().trim() != ""){
                if(!(book2.getAuthor().trim().toLowerCase().contains(book.getAuthor().trim().toLowerCase()))){
                    continue;
                }
            }
            if(book.getTitle().trim() != ""){
                if(!(book2.getTitle().trim().toLowerCase().contains(book.getTitle().trim().toLowerCase()))){
                    continue;
                }
            }
            if(book.getPublisher().trim() != ""){
                if(!(book2.getPublisher().trim().toLowerCase().contains(book.getPublisher().trim().toLowerCase()))){
                    continue;
                }
            }
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
        return returnList;
    }

}

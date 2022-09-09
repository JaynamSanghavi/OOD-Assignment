package syr.edu.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;


public class Library {
    private List<Book> catalog;

    /*
     * Add the book in catalog
     * Assumption: All field are compulsory, if any one is blank it wont add and check if any same book exists or not.
     * For int blank is 0 and for string is "".
     * Param: Book class
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

    //check if contain then set flag to true(continue), for isbn : if book(key) is not null then only check; same for yearPublished

    public String search(Book book){
        String op = "Not Found";
        for (Book book2 : catalog) {
            if((book2.getAuthor().trim().toLowerCase().contains(book.getAuthor().trim().toLowerCase()))){
                if(book2.getTitle().trim().toLowerCase().contains(book.getTitle().trim().toLowerCase())){
                    if(book2.getPublisher().trim().toLowerCase().contains(book.getPublisher().trim().toLowerCase())){
                        if(book.getIsbn() != "" &&  book2.getIsbn().trim().toLowerCase().equals(book.getIsbn().trim().toLowerCase())){
                            if(book.getYearPublished() != 0 &&  book2.getYearPublished() == book.getYearPublished()){
                                    op = "Found";
                            }
                        }
                    }
                }
            }
        }
        return op;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
        Book b4 = new Book("Alan A. A. Donovan", "", "Addison Wesley", "9780134190440",2017);
        Library l = new Library();
        l.add(b1);
        l.add(b2);
        l.add(b3);
        System.out.println(l.catalog);
        l.add(b1);
        System.out.println(l.catalog);
        //l.add(b2);
        System.out.println(l.search(b4));
        //System.out.println(l.search(b1));
    }

    /* 
    
        Check if arraylist is initialized else throw the error message.
        Else, check if key is null or not, if its null then throw error message.
        Else. check if arraylist size is greater then 0, if not then throw error message.
        Else. check if the key is in the list. If found send positive message else send negative message.
    
    */
    // public String search(String key){
    //     String answer = "";
    //     int flag = 0;
    //     if(catalog != null){
    //         if(key.length() > 0){
    //             if(catalog.size() > 0){
    //                 for(int i = 0;i<catalog.size();i++){
    //                     if(catalog.get(i).toLowerCase().contains(key.toLowerCase())){
    //                         answer = "Publication found in the library";
    //                         flag = 1;
    //                         break;
    //                     }
    //                 }
    //                 if(flag == 0){
    //                     answer = "Publication not found in the library";
    //                 }
    //             }else{
    //                 answer = "No item in library catalog";
    //             }   
    //         }else{
    //             answer = "Please give publication name to find";
    //         }
    //     }else{
    //         answer = "Please call init method first";
    //     }
    //     return answer;
    // }
}

package syr.edu.hw2;

public class Book {

    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;

    public Book(String a, String t, String p, String i, int y) {
        this.author = a;
        this.title = t;
        this.publisher = p;
        this.isbn = i;
        this.yearPublished = y;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return "Book{author=" + author + ", isbn=" + isbn + ", publisher=" + publisher + ", title=" + title
                + ", yearPublished=" + yearPublished + "} \n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (!this.author.equals(other.author))
            return false;
        if (!this.isbn.equals(other.isbn))
            return false;
        if (!this.publisher.equals(other.publisher))
            return false;
        if (!this.title.equals(other.title))
            return false;
        if (this.yearPublished != other.yearPublished)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + yearPublished;
        return result;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
    }
}
package syr.edu.hw3;

public class Book {

    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;
    private BookType type;

    

    public Book(String a, String t, String p, String i, int y, BookType type) {
        this.author = a;
        this.title = t;
        this.publisher = p;
        this.isbn = i;
        this.yearPublished = y;
        this.type = type;
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

    public BookType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{author=" + author + ", isbn=" + isbn + ", publisher=" + publisher + ", title=" + title
                + ", yearPublished=" + yearPublished + ", type="+ type+" } \n";
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
        if (this.type != other.type)
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
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + yearPublished;
        return result;
    }
}
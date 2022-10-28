package com.example.reusebook.Service;

import com.example.reusebook.Model.Author;
import com.example.reusebook.Repository.AuthorRepository;
import com.example.reusebook.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<Author> addAuthor(Long bookId, @RequestBody Author author){
        Author a = bookRepository.findById(bookId).map(book -> {
            author.setBook(book);
            return authorRepository.save(author);
        }).orElseThrow();
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Author>> getAllAuthorByBookId(Long bookId) {
        List<Author> authors = authorRepository.findByBookId(bookId);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    public ResponseEntity<Author> updateAuthor(long authorId,Author authorR) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.setName(authorR.getName());
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteAuthor(long id) {
        authorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

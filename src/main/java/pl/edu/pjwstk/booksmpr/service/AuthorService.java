package pl.edu.pjwstk.booksmpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author){
        return authorRepository.createAuthor(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.getAllAuthors();
    }

    public Author getAuthorById(Long id){
        return authorRepository.getAuthorById(id);
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteAuthor(id);
    }
}

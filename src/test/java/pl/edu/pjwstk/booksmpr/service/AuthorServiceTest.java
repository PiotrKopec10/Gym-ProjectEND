package pl.edu.pjwstk.booksmpr.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.repository.AuthorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Author a = new Author();
        //when
        when(authorRepository.save(any())).thenReturn(new Author(99L, "Adam", "Adamowicz"));
        a = authorService.createAuthor(a);
        //then
        assertNotNull(a.getFirstName());
        assertNotNull(a.getLastName());
    }

    @Test
    void Should_ThrowIllegalArgumentExceptionWhenNotFound() {
        //given

        //when
        when(authorRepository.findAuthorByFirstNameAndLastName(any(), any())).thenReturn(Optional.empty());
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            authorService.findByNameAndLastName(any(), any());
        });
    }



    @Test
    void getAllAuthors() {
    }

    @Test
    void getAuthorById() {
    }

    @Test
    void deleteAuthorById() {
    }
}
package repository;

import model.Author;

import java.util.HashMap;
import java.util.List;

public class AuthorRepository {

    HashMap<Long, Author> authorHashMap = new HashMap<>();

    public Author addAuthor(Author author){
        author.setId(findMaxId() + 1L);
        authorHashMap.put(author.getId(), author);

        return author;
    }

    public List<Author> getAllAuthors(){
        return authorHashMap.values().stream().toList();
    }

    public Author updateAuthor(Long id, Author author){
        Author authorToUpdate = authorHashMap.get(id);

        if(!authorToUpdate.getFirstName().equals(author.getFirstName())){

        }
    }

    public void deleteAuthor(Long id){
        authorHashMap.remove(id);
    }

    private Long findMaxId(){
        return authorHashMap.keySet().stream()
                .mapToLong(v -> v).max().getAsLong();
    }
}

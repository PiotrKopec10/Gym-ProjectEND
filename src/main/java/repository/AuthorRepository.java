package repository;

import model.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {

    HashMap<Long, Author> authorHashMap = new HashMap<>();

    public Author creatAuthor(Author author) {
        author.setId(findMaxId());
        authorHashMap.put(findMaxId(), author);

        return author;
    }

    public List<Author> getAllAuthors() {
        return authorHashMap.values()
                .stream().toList();
    }

    public void deleteAuthor(Long id) {
        authorHashMap.remove(id);
    }

    public Author getAuthorById(Long id) {
        if (authorHashMap.containsKey(id)) {
            return authorHashMap.get(id);
        }

        throw new IllegalArgumentException();

    }

    private Long findMaxId() {
        if (authorHashMap.size() == 0) return 0L;
        return authorHashMap.keySet().stream()
                .mapToLong(u -> u).max().getAsLong() + 1;
    }


}

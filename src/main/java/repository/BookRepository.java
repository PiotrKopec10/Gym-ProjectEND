package repository;

import model.Book;

import java.util.HashMap;
import java.util.List;

public class BookRepository {

    HashMap<Long, Book> bookHashMap = new HashMap<>();

    public Book createBook(Book book) {
        book.setId(findMaxId());
        bookHashMap.put(book.getId(), book);
        return book;
    }

    public void deleteBook(Long id){
        if(bookHashMap.containsKey(id)){
            bookHashMap.remove(id);
        }
        throw new IllegalArgumentException();
    }

    public Book getBookById(Long id) {
        if (bookHashMap.containsKey(id)) {
            return bookHashMap.get(id);
        }
        throw new IllegalArgumentException();
    }

    public List<Book> getAllBooks(){
        return bookHashMap.values().stream().toList();
    }

    public Book updateBook(Long id, Book updatedBook){
        Book bookToUpdate = getBookById(id);

        if(!bookToUpdate.getPublisher().equals(updatedBook.getPublisher())){
            bookToUpdate.setPublisher(updatedBook.getPublisher());
        }

        if(!bookToUpdate.getTitle().equals(updatedBook.getTitle())){
            bookToUpdate.setTitle(updatedBook.getTitle());
        }

        if(bookToUpdate.getAuthor().getId().equals(updatedBook.getAuthor().getId())){
            bookToUpdate.setAuthor(updatedBook.getAuthor());
        }

        bookHashMap.put(id, bookToUpdate);

        return bookToUpdate;

    }

    private Long findMaxId() {
        if(bookHashMap.size() == 0) {
            return 0L;
        }
        return bookHashMap.keySet().stream()
                .mapToLong(a-> a)
                .max()
                .getAsLong() + 1;
    }

}

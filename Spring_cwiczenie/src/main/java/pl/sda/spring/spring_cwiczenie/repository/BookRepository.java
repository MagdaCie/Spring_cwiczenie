package pl.sda.spring.spring_cwiczenie.repository;

import org.springframework.stereotype.Repository;
import pl.sda.spring.spring_cwiczenie.web.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private static Long bookID = 1L;
    private final List<Book> bookRestList = new ArrayList<>();

    public Book save(Book book) {
        book.setId(bookID++);
        bookRestList.add(book);
        return book;
    }

    public List<Book> findAllBook() {
        return new ArrayList<>(bookRestList);
    }

    public Book findBookById(Long id) {
        return bookRestList.stream().filter(book -> book.getId() == id)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    public boolean deleteById(Long id) {
        bookRestList.remove(findBookById(id));
        return true;
    }
}

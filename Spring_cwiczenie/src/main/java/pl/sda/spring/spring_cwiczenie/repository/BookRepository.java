package pl.sda.spring.spring_cwiczenie.repository;

import org.springframework.stereotype.Repository;
import pl.sda.spring.spring_cwiczenie.web.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private static Long bookID = 1L;
    private final List<Book> bookRestList = new ArrayList<>();


}

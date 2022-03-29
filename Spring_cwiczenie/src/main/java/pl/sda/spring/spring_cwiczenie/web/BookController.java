package pl.sda.spring.spring_cwiczenie.web;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.spring.spring_cwiczenie.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

/*    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks {
        return ResponseEntity.ok
    }*/
}

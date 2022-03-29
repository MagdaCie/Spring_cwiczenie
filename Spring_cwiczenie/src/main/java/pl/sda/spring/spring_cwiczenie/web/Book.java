package pl.sda.spring.spring_cwiczenie.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private Long id;
    private String bookName;
    private String author;

}

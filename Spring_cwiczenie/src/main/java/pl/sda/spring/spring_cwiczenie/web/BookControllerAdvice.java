package pl.sda.spring.spring_cwiczenie.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String handleIndex(IndexOutOfBoundsException e) {
        return "This is out of bound exception" + e.getMessage();
    }
}

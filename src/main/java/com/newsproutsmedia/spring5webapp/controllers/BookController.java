package com.newsproutsmedia.spring5webapp.controllers;

import com.newsproutsmedia.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    // Inject instance of BookRepository for CRUD operations
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Invoked when client goes to "/books" URL
    @RequestMapping("/books")
    public String getBooks(Model model) {

        // Get list of books from database and pass to view as "books" variable
        model.addAttribute("books", bookRepository.findAll());

        // Send client to view file "books"
        return "books";
    }

}

package fi.haagahelia.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping("/index")
	public String index() {

		return "index";
	}

}


package fi.haagahelia.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.Category;
import fi.haagahelia.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryrepository) {
		return (args) -> {
			log.info("save a couple of books");
			categoryrepository.save(new Category("American"));
			categoryrepository.save(new Category("English"));
			categoryrepository.save(new Category("Other"));

			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "1929", "1232323-21", 39.99,
					categoryrepository.findByName("American").get(0)));
			repository.save(new Book("Animal Farm", "George Orwell", "1945", "2212343-5", 38.99,
					categoryrepository.findByName("English").get(0)));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};

	}

}

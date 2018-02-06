package io.alphyon.tuto1.bootstrap;

import io.alphyon.tuto1.model.Author;
import io.alphyon.tuto1.model.Book;
import io.alphyon.tuto1.model.Publisher;
import io.alphyon.tuto1.repositories.AuthorRepository;
import io.alphyon.tuto1.repositories.BookRepository;
import io.alphyon.tuto1.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBoostrap implements ApplicationListener<ContextRefreshedEvent>{
    private AuthorRepository autorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBoostrap(AuthorRepository autorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.autorRepository = autorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Author jose = new Author("Jose", "Chavarria");
        Publisher publisher = new Publisher();
        publisher.setName("Chava Editores");
        publisher.setAddress("Calle el progreso");
        publisherRepository.save(publisher);

        Book libro1 = new Book("JPA init", "1234", publisher);
        jose.getBooks().add(libro1);
        libro1.getAuthors().add(jose);

        autorRepository.save(jose);
        bookRepository.save(libro1);

        Author pedro = new Author("Pedro", "Perez");
        Book libro2 = new Book("JPA Avance", "4567",  publisher);
        pedro.getBooks().add(libro2);
        libro2.getAuthors().add(pedro);

        autorRepository.save(pedro);
        bookRepository.save(libro2);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}

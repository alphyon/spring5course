package io.alphyon.tuto1.repositories;

import io.alphyon.tuto1.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

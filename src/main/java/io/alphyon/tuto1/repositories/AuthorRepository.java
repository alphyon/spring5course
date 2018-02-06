package io.alphyon.tuto1.repositories;

import io.alphyon.tuto1.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long>{

}

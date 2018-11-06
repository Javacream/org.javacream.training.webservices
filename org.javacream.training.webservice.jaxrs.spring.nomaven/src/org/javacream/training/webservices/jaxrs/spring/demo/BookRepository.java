package org.javacream.training.webservices.jaxrs.spring.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String>{

}

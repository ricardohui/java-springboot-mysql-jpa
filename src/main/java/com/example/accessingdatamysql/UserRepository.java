package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// In a typical Java application, you might expect to write a class that implements CustomerRepository. However, that
// is what makes Spring Data JPA so powerful: You need not write an implementation of the repository interface. Spring Data JPA creates an implementation when you run the application.
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByName(String name);

    Optional<User> findById(Integer id);
}

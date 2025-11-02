package com.milestone.repository;

import org.springframework.data.repository.CrudRepository;
import com.milestone.model.RegisterModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Repository interface for accessing user data from the database.
 */
@Repository
public interface UserRepository extends CrudRepository<RegisterModel, Long> {

    /**
     * Finds a user by their username.
     * 
     * @param username the username to search for
     * @return an Optional containing the user if found, or empty if not
     */
    Optional<RegisterModel> findByUsername(String username);
}

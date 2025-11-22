package com.milestone.repository;

<<<<<<< HEAD
import com.milestone.model.RegisterModel;
import com.milestone.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
=======
import org.springframework.data.repository.CrudRepository;
import com.milestone.model.RegisterModel;
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
import org.springframework.stereotype.Repository;

import java.util.Optional;

<<<<<<< HEAD
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}

=======

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
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53

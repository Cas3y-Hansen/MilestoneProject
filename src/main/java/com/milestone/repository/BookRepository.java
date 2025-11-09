package com.milestone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.milestone.model.BookModel;

/**
 * Repository interface for managing {@link BookModel} entities.
 * Extends {@link JpaRepository} to provide CRUD operations.
 */
@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {
}

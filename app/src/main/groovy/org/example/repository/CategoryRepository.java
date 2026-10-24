package org.example.repository;

import org.example.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Used by the Data Seeder to check if a category already exists
    Optional<Category> findByName(String name);
}

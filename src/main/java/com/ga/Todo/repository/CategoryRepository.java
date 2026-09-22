package com.ga.Todo.repository;

import com.ga.Todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
    Category findByNameAndDescription(String categoryName, String categoryDescription);

}

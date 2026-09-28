package com.ga.Todo.repository;

import com.ga.Todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
    Category findByNameAndDescription(String categoryName, String categoryDescription);
    Category findByIdAndUserId(Long categoryId, Long userId);
    Category findByUserIdAndName(Long categoryId, String categoryName);
    List<Category> findByUserId(Long userId);

}

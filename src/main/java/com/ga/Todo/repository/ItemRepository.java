package com.ga.Todo.repository;

import com.ga.Todo.model.Category;
import com.ga.Todo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoryId(Long categoryId);

}

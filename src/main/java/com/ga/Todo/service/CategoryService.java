package com.ga.Todo.service;

import com.ga.Todo.exception.InformationExistException;
import com.ga.Todo.model.Category;
import com.ga.Todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category categoryObject){
        Category category = categoryRepository.findByName(categoryObject.getName());
        if(category != null){
            throw new InformationExistException("category with name" + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category Id not found"));
    }

    public Category updateCategory(Long categoryId, Category categoryObject){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category Id not found"));
        category.setName(categoryObject.getName());
        category.setDescription(categoryObject.getDescription());

        return  categoryRepository.save(category);
    }

    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category Id not found"));

        categoryRepository.delete(category);
        return "Category with id " + categoryId + " is successfully deleted.";
    }
}

package com.ga.Todo.service;

import com.ga.Todo.exception.InformationExistException;
import com.ga.Todo.exception.InformationNotFoundException;
import com.ga.Todo.model.Category;
import com.ga.Todo.model.User;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public static User getCurrentLoggedInUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }

    public Category createCategory(Category categoryObject){
        Category category = categoryRepository.findByUserIdAndName(CategoryService.getCurrentLoggedInUser().getId(), categoryObject.getName());
        if(category != null){
            throw new InformationExistException("category with name" + category.getName() + " already exists");
        } else {
            categoryObject.setUser(getCurrentLoggedInUser());
            return categoryRepository.save(categoryObject);
        }
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId){
        System.out.println("Service Calling getCategoryById ==> ");
        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("Category Id not found");
        }
        return category;
    }

    public Category updateCategory(Long categoryId, Category categoryObject){
        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("Category Id not found");
        }
        category.setName(categoryObject.getName());
        category.setDescription(categoryObject.getDescription());

        return  categoryRepository.save(category);
    }

    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findByIdAndUserId(categoryId, getCurrentLoggedInUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("Category Id not found");
        }
        categoryRepository.delete(category);
        return "Category with id " + categoryId + " is successfully deleted.";
    }
}

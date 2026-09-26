package com.ga.Todo.service;

import com.ga.Todo.exception.InformationNotFoundException;
import com.ga.Todo.model.Category;
import com.ga.Todo.model.Item;
import com.ga.Todo.repository.CategoryRepository;
import com.ga.Todo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public List<Item> getItems(Long categoryId){
        return itemRepository.findByCategoryId(categoryId);
    }

    public Item createItem(Long categoryId, Item item){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("Category with id " + categoryId + " not found" ));
        item.setCategory(category);
        return itemRepository.save(item);
    }

    public Item getItemById(Long categoryId, Long itemId){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("Category with id " + categoryId + " not found" ));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Item with id " + itemId + " not found"));
        return item;
    }

    public Item updateItem(Long categoryId, Long itemId, Item itemObject){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("Category with id " + categoryId + " not found" ));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Item with id " + itemId + " not found"));
        item.setCategory(itemObject.getCategory());
        item.setDescription(itemObject.getDescription());
        item.setName(itemObject.getName());
        item.setDueDate(itemObject.getDueDate());

        itemRepository.save(item);
        return item;
    }

    public Item deleteItem(Long categoryId, Long itemId){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException("Category with id " + categoryId + " not found" ));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new InformationNotFoundException("Item with id " + itemId + " not found"));
        itemRepository.delete(item);
        return item;
    }
}

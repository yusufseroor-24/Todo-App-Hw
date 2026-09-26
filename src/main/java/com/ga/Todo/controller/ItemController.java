package com.ga.Todo.controller;

import com.ga.Todo.model.Item;
import com.ga.Todo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/categories/{categoryId}/items")
    public List<Item> getItems(@PathVariable(value = "categoryId") Long categoryId){
        return itemService.getItems(categoryId);
    }

    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(@PathVariable(value = "categoryId") Long categoryId,
                           @RequestBody Item item){
        return itemService.createItem(categoryId, item);
    }

    @GetMapping("/categories/{categoryId}/items/{itemId}")
    public Item getItemById(@PathVariable(value = "categoryId") Long categoryId,
                            @PathVariable(value = "itemId") Long itemId){
        return itemService.getItemById(categoryId, itemId);
    }

    @PutMapping("/categories/{categoryId}/items/{itemId}")
    public Item updateItem(@PathVariable(value = "categoryId") Long categoryId,
                           @PathVariable(value = "itemId") Long itemId,
                           @RequestBody Item itemObject){
        return itemService.updateItem(categoryId, itemId, itemObject);
    }

    @DeleteMapping("/categories/{categoryId}/items/{itemId}")
    public Item deleteItem(@PathVariable(value = "categoryId") Long categoryId,
                           @PathVariable(value = "itemId") Long itemId){
        return itemService.deleteItem(categoryId, itemId);
    }
}

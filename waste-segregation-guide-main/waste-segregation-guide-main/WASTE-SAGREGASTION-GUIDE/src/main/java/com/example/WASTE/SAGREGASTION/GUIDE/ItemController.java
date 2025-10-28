package com.example.WASTE.SAGREGASTION.GUIDE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // CREATE: POST to /api/items/add
    @PostMapping("/add")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.addItem(item.getItemName(), item.getCategory(), item.getAdvantages());
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    // READ: GET to /api/items/search?query=term
    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItem(@RequestParam String query) {
        List<Item> results = itemService.searchItem(query);
        if (results.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(results);
    }

    // DELETE: DELETE to /api/items/delete/{itemName}
    @DeleteMapping("/delete/{itemName}")
    public ResponseEntity<Void> deleteItem(@PathVariable String itemName) {
        boolean deleted = itemService.deleteItem(itemName);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

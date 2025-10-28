package com.example.WASTE.SAGREGASTION.GUIDE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(String itemName, String category, String advantages) {
        Item item = new Item(itemName, category, advantages);
        return itemRepository.save(item);
    }

    public boolean deleteItem(String itemName) {
        Optional<Item> item = itemRepository.findByItemName(itemName);
        if (item.isPresent()) {
            itemRepository.delete(item.get());
            return true;
        }
        return false;
    }

    public List<Item> searchItem(String query) {
        return itemRepository.findByItemNameContainingIgnoreCase(query);
    }
}

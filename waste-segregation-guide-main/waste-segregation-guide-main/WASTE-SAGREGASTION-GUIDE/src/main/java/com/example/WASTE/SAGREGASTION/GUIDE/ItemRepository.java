package com.example.WASTE.SAGREGASTION.GUIDE;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByItemName(String itemName);
    List<Item> findByItemNameContainingIgnoreCase(String query);
}

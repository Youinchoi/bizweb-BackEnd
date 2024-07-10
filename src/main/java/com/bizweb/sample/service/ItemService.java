package com.bizweb.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizweb.sample.entity.Item;
import com.bizweb.sample.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
    private ItemRepository itemRepository;

	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	public Item findById(Long id) {
		return itemRepository.findById(id).orElse(null);
	}
	
	public void create(Item item) {
		itemRepository.save(item);
	}
	
	public Item updateById(Long id, Item item) {
        return itemRepository.save(item);
	}

	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}
	
}
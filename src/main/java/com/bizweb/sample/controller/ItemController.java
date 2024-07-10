package com.bizweb.sample.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizweb.sample.entity.Item;
import com.bizweb.sample.service.ItemService;


//@Controller
@RestController
@RequestMapping("/sample/item")
public class ItemController {
	private final  ItemService itemService;

	// 의존성 생성자 주입
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	// 리스트 조회
	@GetMapping("/items")
	public List<Item> findAllItem() {
		return itemService.findAll();
	}

	// 단건 조회
	@GetMapping("/item/{id}")
	public Item findItemById(@PathVariable Long id) {
		return itemService.findById(id);
	}
	
	// 저장
	@PostMapping("/item")
	public void save(@RequestBody Item item) {
		itemService.create(item);
	}

	// 수정
	@PatchMapping("/item/{id}")
	public void updateItemById(@PathVariable Long id, @RequestBody Item item) {
		itemService.updateById(id, item);
	}

	// 삭제
	@DeleteMapping("item/{id}")
	public void deleteItemById(@PathVariable Long id) {
		itemService.deleteById(id);
	}
	
}
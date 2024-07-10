package com.bizweb.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizweb.sample.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findByUid(String uid);

}

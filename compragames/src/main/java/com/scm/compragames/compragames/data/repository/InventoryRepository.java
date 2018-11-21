package com.scm.compragames.compragames.data.repository;

import com.scm.compragames.compragames.data.model.Inventory;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InventoryRepository extends ParenthoodRepository<Inventory, Long> {
}

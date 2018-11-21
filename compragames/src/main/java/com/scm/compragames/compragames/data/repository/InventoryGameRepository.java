package com.scm.compragames.compragames.data.repository;

import com.scm.compragames.compragames.data.model.InventoryGame;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InventoryGameRepository extends ParenthoodRepository<InventoryGame, Long> {
}

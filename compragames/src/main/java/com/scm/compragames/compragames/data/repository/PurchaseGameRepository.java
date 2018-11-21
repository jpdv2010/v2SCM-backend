package com.scm.compragames.compragames.data.repository;

import com.scm.compragames.compragames.data.model.Game;
import com.scm.compragames.compragames.data.model.PurchaseGame;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PurchaseGameRepository extends ParenthoodRepository<PurchaseGame, Long> {
}

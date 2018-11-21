package com.scm.compragames.compragames.data.repository;

import com.scm.compragames.compragames.data.model.Game;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GameRepository extends ParenthoodRepository<Game, Long> {
}

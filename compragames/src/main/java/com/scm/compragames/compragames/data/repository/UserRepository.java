package com.scm.compragames.compragames.data.repository;

import com.scm.compragames.compragames.data.model.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends ParenthoodRepository<User, Long> {
}

package com.scm.compragames.compragames.data.repository;

import com.scm.compragames.compragames.data.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface ParenthoodRepository <T extends BaseModel, K extends Serializable> extends JpaRepository< T, K >, JpaSpecificationExecutor< T > {
}

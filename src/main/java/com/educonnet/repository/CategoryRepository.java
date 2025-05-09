package com.educonnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educonnet.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

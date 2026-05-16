package com.animeslist.animeslist.repository;

import com.animeslist.animeslist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}

package com.buuth.app.apireactjs.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buuth.app.apireactjs.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Optional<Category> findByIdAndDeletedFalse(Long id);

	Page<Category> findAllByDeletedFalse(Pageable pageable);
}

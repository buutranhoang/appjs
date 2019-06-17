package com.buuth.app.apireactjs.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buuth.app.apireactjs.constants.SortConstants;
import com.buuth.app.apireactjs.exception.ResourceNotFoundException;
import com.buuth.app.apireactjs.model.Category;
import com.buuth.app.apireactjs.service.AppReatjsService;
import com.buuth.app.apireactjs.service.dto.category.create.CreateCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.delete.DeleteCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.list.CategoryDetailDto;
import com.buuth.app.apireactjs.service.dto.category.list.GetCategoryQuery;
import com.buuth.app.apireactjs.service.dto.category.update.UpdateCategoryDto;
import com.buuth.app.apireactjs.service.inter.ICategoryService;
import com.buuth.app.apireactjs.service.mapper.CategoryMapper;
import com.buuth.app.apireactjs.util.PagedResponse;

@Service
@Transactional
public class CategoryServiceImpl extends AppReatjsService implements ICategoryService {

	@Override
	public PagedResponse<CategoryDetailDto> handle(GetCategoryQuery query) {
		validatePageNumberAndSize(query.getPage(), query.getSize());
		Pageable pageable = PageRequest.of(query.getPage(), query.getSize(), Sort.Direction.DESC,
				SortConstants.CREATED_AT);
		Page<Category> categoryPage = this.categoryRepository.findAllByDeletedFalse(pageable);

		if (categoryPage.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), categoryPage.getNumber(), categoryPage.getSize(),
					categoryPage.getTotalElements(), categoryPage.getTotalPages(), categoryPage.isLast());
		}

		List<CategoryDetailDto> categoryDetailDtos = new ArrayList<>();
		for (Category category : categoryPage) {
			CategoryDetailDto categoryDetailDto = CategoryMapper.INSTANCE.toCategoryDetailDto(category);
			categoryDetailDtos.add(categoryDetailDto);
		}
		return new PagedResponse<>(categoryDetailDtos, categoryPage.getNumber(), categoryPage.getSize(),
				categoryPage.getTotalElements(), categoryPage.getTotalPages(), categoryPage.isLast());
	}

	@Override
	public void handle(CreateCategoryDto cmd) {
		Category category = CategoryMapper.INSTANCE.toCategoryEntity(cmd);
		this.categoryRepository.save(category);
	}

	@Override
	public void handle(UpdateCategoryDto cmd) {
		Category category = this.categoryRepository.findByIdAndDeletedFalse(cmd.getId())
				.orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), "id", cmd.getId()));
		CategoryMapper.INSTANCE.toCategoryEntity(cmd, category);
		this.categoryRepository.save(category);
	}

	@Override
	public void handle(DeleteCategoryDto cmd) {
		Category category = this.categoryRepository.findByIdAndDeletedFalse(cmd.getId())
				.orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), "id", cmd.getId()));
		category.setDeleted(true);
		category.setDeleteAt(Instant.now());
		category.setDeleteBy(cmd.getUserPrincipal().getId());
		this.categoryRepository.save(category);
	}

}

package com.buuth.app.apireactjs.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.buuth.app.apireactjs.security.CurrentUser;
import com.buuth.app.apireactjs.security.UserPrincipal;
import com.buuth.app.apireactjs.service.dto.category.create.CreateCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.delete.DeleteCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.list.CategoryDetailDto;
import com.buuth.app.apireactjs.service.dto.category.list.GetCategoryQuery;
import com.buuth.app.apireactjs.service.dto.category.update.UpdateCategoryDto;
import com.buuth.app.apireactjs.service.inter.ICategoryService;
import com.buuth.app.apireactjs.util.AppConstants;
import com.buuth.app.apireactjs.util.PagedResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/categorys")
@Api(value = "Category Management System")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@GetMapping
	@ApiOperation("List Category")
	public PagedResponse<CategoryDetailDto> getCategorys(@CurrentUser UserPrincipal currentUser,
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		logger.info("getCategorys");

		GetCategoryQuery getCategoryQuery = new GetCategoryQuery();
		getCategoryQuery.setPage(page);
		getCategoryQuery.setSize(size);
		getCategoryQuery.setUserPrincipal(currentUser);

		return categoryService.handle(getCategoryQuery);
	}

	@PostMapping
	@ApiOperation("Create Category")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto) {
		categoryService.handle(createCategoryDto);
	}

	@PutMapping("/{id}")
	@ApiOperation("Update Category")
	@ResponseStatus(HttpStatus.OK)
	public void updateCategory(@PathVariable("id") Long id, @Valid @RequestBody UpdateCategoryDto updateCategoryDto) {
		updateCategoryDto.setId(id);
		categoryService.handle(updateCategoryDto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Delete Category")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(@PathVariable("id") Long id, @CurrentUser UserPrincipal currentUser) {
		DeleteCategoryDto deleteCategoryDto = new DeleteCategoryDto();
		deleteCategoryDto.setId(id);
		deleteCategoryDto.setUserPrincipal(currentUser);
		categoryService.handle(deleteCategoryDto);
	}
}

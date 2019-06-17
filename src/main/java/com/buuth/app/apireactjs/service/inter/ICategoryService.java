package com.buuth.app.apireactjs.service.inter;

import com.buuth.app.apireactjs.service.dto.category.create.CreateCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.delete.DeleteCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.list.CategoryDetailDto;
import com.buuth.app.apireactjs.service.dto.category.list.GetCategoryQuery;
import com.buuth.app.apireactjs.service.dto.category.update.UpdateCategoryDto;
import com.buuth.app.apireactjs.util.PagedResponse;

public interface ICategoryService {

	PagedResponse<CategoryDetailDto> handle(GetCategoryQuery query);

	void handle(CreateCategoryDto cmd);

	void handle(UpdateCategoryDto cmd);

	void handle(DeleteCategoryDto cmd);
}

package com.buuth.app.apireactjs.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.buuth.app.apireactjs.model.Category;
import com.buuth.app.apireactjs.service.dto.category.create.CreateCategoryDto;
import com.buuth.app.apireactjs.service.dto.category.list.CategoryDetailDto;
import com.buuth.app.apireactjs.service.dto.category.update.UpdateCategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDetailDto toCategoryDetailDto(Category entity);
    
    Category toCategoryEntity(CreateCategoryDto dto);
    
    void toCategoryEntity(UpdateCategoryDto dto, @MappingTarget Category entity);
    
}

package com.buuth.app.apireactjs.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.buuth.app.apireactjs.exception.BadRequestException;
import com.buuth.app.apireactjs.repository.CategoryRepository;
import com.buuth.app.apireactjs.util.AppConstants;

public abstract class AppReatjsService {

	@Autowired
	protected CategoryRepository categoryRepository;
	
	
	
	protected void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}

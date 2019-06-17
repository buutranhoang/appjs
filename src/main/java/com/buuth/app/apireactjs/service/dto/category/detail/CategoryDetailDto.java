package com.buuth.app.apireactjs.service.dto.category.detail;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class CategoryDetailDto {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

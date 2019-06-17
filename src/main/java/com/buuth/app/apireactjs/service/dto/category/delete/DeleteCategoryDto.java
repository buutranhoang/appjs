package com.buuth.app.apireactjs.service.dto.category.delete;

import com.buuth.app.apireactjs.security.UserPrincipal;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class DeleteCategoryDto {

	@JsonProperty("id")
	private Long id;

	private UserPrincipal userPrincipal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserPrincipal getUserPrincipal() {
		return userPrincipal;
	}

	public void setUserPrincipal(UserPrincipal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}

}

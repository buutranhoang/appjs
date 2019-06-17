package com.buuth.app.apireactjs.service.dto.category.list;

import com.buuth.app.apireactjs.security.UserPrincipal;

public class GetCategoryQuery {

	private int page;
	private int size;
	private UserPrincipal userPrincipal;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public UserPrincipal getUserPrincipal() {
		return userPrincipal;
	}
	public void setUserPrincipal(UserPrincipal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}
	
}

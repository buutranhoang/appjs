package com.buuth.app.apireactjs.model.audit;

import java.time.Instant;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(value = { "createdBy", "updatedBy" }, allowGetters = true)
public abstract class UserDateAudit extends DateAudit {

	@CreatedBy
	private Long createdBy;

	@LastModifiedBy
	private Long updatedBy;

	private Boolean deleted;

	private Long deleteBy;

	private Instant deleteAt;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(Long deleteBy) {
		this.deleteBy = deleteBy;
	}

	public Instant getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(Instant deleteAt) {
		this.deleteAt = deleteAt;
	}

}

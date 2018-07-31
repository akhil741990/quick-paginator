package com.soul.pagination.db.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="auditlog")
public class AuditLog {

	@Id
    @GeneratedValue
	private Integer auditLogId;
	
	private String action;
	
	private String detail;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="entity_id")
	private Integer entityId;
	
	@Column(name="entity_name")
	private String entityName;
	
	
	public Integer getAuditLogId() {
		return auditLogId;
	}
	public void setAuditLogId(Integer auditLogId) {
		this.auditLogId = auditLogId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
}

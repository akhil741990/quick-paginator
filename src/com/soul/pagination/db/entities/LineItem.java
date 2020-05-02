package com.soul.pagination.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="line_item")
public class LineItem {
	
	@Id
    @GeneratedValue
    private Integer id;
	private String name;
	private Long imp;
	
	
	@OneToOne
	@JoinColumn(name="io_id",referencedColumnName="id")
	@JsonIgnore
	private InsertionOrder io;
	
	public InsertionOrder getIo() {
		return io;
	}
	public void setIo(InsertionOrder io) {
		this.io = io;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getImp() {
		return imp;
	}
	public void setImp(Long imp) {
		this.imp = imp;
	}
	

}

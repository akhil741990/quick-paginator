package com.soul.pagination.db.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="insertion_order")
public class InsertionOrder {

	@Id
    @GeneratedValue
    private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name="advertiser_id", referencedColumnName="id")
	@JsonIgnore
	private Advertiser adv;
	
	public List<LineItem> getLis() {
		return lis;
	}
	public void setLis(List<LineItem> lis) {
		this.lis = lis;
	}
	@OneToMany
	@JoinColumn(name="io_id")
	private List<LineItem> lis;
	
	@Column(name="is_active")
	private int isActive;
	
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
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
	public Advertiser getAdv() {
		return adv;
	}
	public void setAdv(Advertiser adv) {
		this.adv = adv;
	}
	
}

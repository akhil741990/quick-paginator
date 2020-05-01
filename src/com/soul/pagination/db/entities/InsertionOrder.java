package com.soul.pagination.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity(name="insertion_order")
public class InsertionOrder {

	@Id
    @GeneratedValue
    private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name="advertiser_id", referencedColumnName="id")
	private Advertiser adv;
	
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

package com.soul.pagination.db.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="advertiser")
public class Advertiser {

	@Id
    @GeneratedValue
    private Integer id;
	private String name;
    private String address;
    
    @OneToMany
    @JoinColumn(name="advertiser_id")
    private List<InsertionOrder> ios;
    
	public List<InsertionOrder> getIos() {
		return ios;
	}
	public void setIos(List<InsertionOrder> ios) {
		this.ios = ios;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}

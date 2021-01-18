package com.qintess.desafio_grupo.entities;

import com.qintess.desafio_grupo.dao.CustomerDao;

public class Customer {

	private Integer customer_id;
	private Integer store_id;
	private String first_name;
	private String last_name;
	private String email;
	private Integer address_id;
	private boolean activebool;
	private String create_date;
	private String last_update;
	private Integer active;
	
	public Customer() {}
	
	public Customer(Integer customer_id, Integer store_id, String first_name, String last_name, String email,
			Integer address_id, boolean activebool, String create_date, String last_update, Integer active) {
		super();
		this.customer_id = customer_id;
		this.store_id = store_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address_id = address_id;
		this.activebool = activebool;
		this.create_date = create_date;
		this.last_update = last_update;
		this.active = active;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public boolean isActivebool() {
		return activebool;
	}

	public void setActivebool(boolean activebool) {
		this.activebool = activebool;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", store_id=" + store_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", address_id=" + address_id + ", activebool="
				+ activebool + ", create_date=" + create_date + ", last_update=" + last_update + ", active=" + active
				+ "]";
	}

	
	
}

package com.qintess.desafio_grupo.entities;

public class Address {

	private Integer address_id;
	private Integer address;
	private String district;
	private Integer city_id;
	private Integer postal_code;
	private Long phone;
	private String last_update;
	
	public Address() {}

	public Address(Integer address_id, Integer address, String district, Integer city_id, Integer postal_code,
			Long phone, String last_update) {
		super();
		this.address_id = address_id;
		this.address = address;
		this.district = district;
		this.city_id = city_id;
		this.postal_code = postal_code;
		this.phone = phone;
		this.last_update = last_update;
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public Integer getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(Integer postal_code) {
		this.postal_code = postal_code;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
}

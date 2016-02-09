package com.dev.frontend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String code;
	private String name;
	private String address;
	private String phone1;
	private String phone2;
	private Long creditLimit = 0L;
	private Long currentLimit = 0L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Long getCurrentLimit() {
		return currentLimit;
	}
}
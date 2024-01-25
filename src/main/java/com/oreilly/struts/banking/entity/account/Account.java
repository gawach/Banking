package com.oreilly.struts.banking.entity.account;

import java.io.Serializable;

public class Account implements Serializable {
	
	private Integer id;
	
	private Integer balance;
	
	private Integer memberId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
		

}

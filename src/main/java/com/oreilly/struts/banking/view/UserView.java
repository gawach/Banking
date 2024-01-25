package com.oreilly.struts.banking.view;

import java.util.HashSet;
import java.util.Set;

/**
 * ユーザのセキュリティ情報すべてをラッピングする値オブジェクト
 */
public class UserView implements java.io.Serializable {
	
	private Integer id;
	
	private String name;
	
	private Integer balance;
	
	// Stringoオブジェクトpermissionの一意コレクション
	private Set permissions = null;
	
	public UserView(Integer id, String name, int balance) {
		this(id, name, balance, new HashSet());
	}
	
	public UserView(Integer id, String name, int balance, Set userPermissions) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.permissions = userPermissions;
	}
	
	public boolean containsPermission(String permissionName) {
		return permissions.contains(permissionName);
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	
}

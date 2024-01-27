package com.oreilly.struts.banking.service;

public class InvalidLoginException extends Exception {
	public InvalidLoginException(String msg) {
		super(msg);
	}
}

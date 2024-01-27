package com.oreilly.struts.banking.service;

import com.oreilly.struts.banking.exception.InvalidLoginException;
import com.oreilly.struts.banking.view.UserView;

import net.sf.hibernate.HibernateException;

/**
 * 
 */
public interface IAuthentication {
	/**
	 * 
	 * 
	 * @param accessNumber- 
	 * @param pin- 
	 * @returns 
	 * @throws InvalidLoginException 
	 */
	public UserView login( String accessNumber, String pin)
	  throws InvalidLoginException, HibernateException;

}

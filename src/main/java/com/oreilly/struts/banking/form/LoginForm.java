package com.oreilly.struts.banking.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

/*
 * 
 * 
 * 
 */
public class LoginForm extends ActionForm {
	private String pinNumber;
	private String accessNumber;

	public LoginForm() {
		super();
		resetFields();
	}
	
	/* 
	 * 
	 * 
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest req) {
		ActionErrors errors = new ActionErrors();
		
//		MessageResources resources = (MessageResources) req.getAttribute(Action.MESSAGE_KEY);
		MessageResources resources = MessageResources.getMessageResources("resources.application");
		
		if(accessNumber == null || accessNumber.length() == 0) {
			String accessNumberLabel = resources.getMessage("label.accessnumber");
			ActionError newError = new ActionError("global.error.login.requiredfield", accessNumberLabel);
			errors.add(ActionErrors.GLOBAL_ERROR, newError);
		}
		
		if(pinNumber == null || pinNumber.length() == 0) {
			String pinNumberLabel = resources.getMessage("label.pinnumber");
			ActionError newError = new ActionError("global.error.login.requiredfield", pinNumberLabel);
			errors.add(ActionErrors.GLOBAL_ERROR, newError);
		}
		
		return errors;
	}
	
	/**
	 * 
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		resetFields();
	}
	
	/**
	 *  
	 */
	public void resetFields() {
		this.accessNumber = "";
		this.pinNumber = "";
	}
	
	public void setAccessNumber(String nbr) {
		this.accessNumber = nbr;
	}
	
	public String getAccessNumber() {
		return this.accessNumber;
	}
	
	public void setPinNumber(String nbr) {
		this.pinNumber = nbr;
	}
	
	public String getPinNumber() {
		return this.pinNumber;
	}
}

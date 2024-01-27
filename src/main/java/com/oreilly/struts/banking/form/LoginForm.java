package com.oreilly.struts.banking.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

/*
 * ユーザが入力したアクセス番号と暗証番号を検証する
 * どちらか、または両方のフィールドが空白の場合、
 * エラーメッセージを生成する
 */
public class LoginForm extends ActionForm {
	// ユーザの暗証番号
	private String pinNumber;
	// ユーザのアクセス番号
	private String accessNumber;

	public LoginForm() {
		super();
		resetFields();
	}
	
	/* 
	 * ユーザがaccessNumberとpinNumberフィールドに入力した値を検証するために
	 * フレームワークが呼び出す
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest req) {
		ActionErrors errors = new ActionErrors();
		
		// このアプリケーション用のメッセージリソースにアクセスする
		// ActionFormからメッセージリソースにアクセスする容易な方法はない
//		MessageResources resources = (MessageResources) req.getAttribute(Action.MESSAGE_KEY);
		MessageResources resources = MessageResources.getMessageResources("resources.application");
		
		// アクセス番号が入力されているかを確認する
		if(accessNumber == null || accessNumber.length() == 0) {
			String accessNumberLabel = resources.getMessage("label.accessnumber");
			ActionError newError = new ActionError("global.error.login.requiredfield", accessNumberLabel);
			errors.add(ActionErrors.GLOBAL_ERROR, newError);
		}
		
		// 暗証番号が入力されているか確認
		if(pinNumber == null || pinNumber.length() == 0) {
			String pinNumberLabel = resources.getMessage("label.pinnumber");
			ActionError newError = new ActionError("global.error.login.requiredfield", pinNumberLabel);
			errors.add(ActionErrors.GLOBAL_ERROR, newError);
		}
		
		// ActionErrorsを返す
		return errors;
	}
	
	/**
	 * フィールドを規定値に戻すためのフレームワークを呼び出す
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// accessNumberとpinNumberフィールドをクリアする
		resetFields();
	}
	
	/**
	 * フィールドを既定値に戻す 
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

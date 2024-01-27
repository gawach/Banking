package com.oreilly.struts.banking.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.oreilly.struts.banking.form.LoginForm;
import com.oreilly.struts.banking.service.IAuthentication;
import com.oreilly.struts.banking.service.SecurityService;
import com.oreilly.struts.banking.view.UserView;

import resources.IConstants;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping,
																 ActionForm form,
																 HttpServletRequest request,
																 HttpServletResponse response)
																		 throws Exception {
    	// 完了時に返されるActionForward
    	ActionForward foward = null;
    	UserView userView = null;
    	
    	// LoginFormから身分証明を取得する
  		// 入力値チェック
			// エラー内容をセッションに詰める
    	String accessNbr = ((LoginForm) form).getAccessNumber();
    	String pinNbr = ((LoginForm) form).getPinNumber();
    	
    	/*
    	 * 実際のアプリケーションでは、通常JNDIやファクトリなどから
    	 * セキュリティサービスの参照を取得する
    	 */
    	IAuthentication service = new SecurityService();
    	
    	// ログインを行う
    	userView = service.login(accessNbr, pinNbr);
    	
    	// 既存のセッションがあれば、無効にする
    	HttpSession session = request.getSession(false);
    	if(session != null) {
    		session.invalidate();
    	}
    	
    	// ユーザ用の新しいセッションを生成する
    	session = request.getSession(true);
    	
    	// UserViewをセッションに格納して戻る
    	session.setAttribute(IConstants.USER_VIEW_KEY, userView);
    	foward = mapping.findForward(IConstants.SUCCESS_KEY);
    	return foward;
    }

}

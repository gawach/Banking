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
    	// �������ɕԂ����ActionForward
    	ActionForward foward = null;
    	UserView userView = null;
    	
    	// LoginForm����g���ؖ����擾����
  		// ���͒l�`�F�b�N
			// �G���[���e���Z�b�V�����ɋl�߂�
    	String accessNbr = ((LoginForm) form).getAccessNumber();
    	String pinNbr = ((LoginForm) form).getPinNumber();
    	
    	/*
    	 * ���ۂ̃A�v���P�[�V�����ł́A�ʏ�JNDI��t�@�N�g���Ȃǂ���
    	 * �Z�L�����e�B�T�[�r�X�̎Q�Ƃ��擾����
    	 */
    	IAuthentication service = new SecurityService();
    	
    	// ���O�C�����s��
    	userView = service.login(accessNbr, pinNbr);
    	
    	// �����̃Z�b�V����������΁A�����ɂ���
    	HttpSession session = request.getSession(false);
    	if(session != null) {
    		session.invalidate();
    	}
    	
    	// ���[�U�p�̐V�����Z�b�V�����𐶐�����
    	session = request.getSession(true);
    	
    	// UserView���Z�b�V�����Ɋi�[���Ė߂�
    	session.setAttribute(IConstants.USER_VIEW_KEY, userView);
    	foward = mapping.findForward(IConstants.SUCCESS_KEY);
    	return foward;
    }

}

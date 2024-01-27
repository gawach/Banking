package com.oreilly.struts.banking.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.oreilly.struts.banking.exception.InvalidLoginException;
import com.oreilly.struts.banking.view.UserView;

public class SecurityServiceTest {

	private SecurityService securityService = new SecurityService();
	
	@Test
	public void ���O�C������() throws Exception {
		String expected = "�c��";
		String accessNumber = "123456789";
		String pinNumber = "1111";
		UserView userView = securityService.login(accessNumber, pinNumber);
		
		String actual = userView.getName();
		assertThat(actual, is(expected));
	}
	
	@Test
	public void ���O�C�����s_�A�N�Z�X�ԍ���PIN�ԍ��̕s��v() throws Exception {
		String accessNumber = "123456789";
		String pinNumber = "0000";
		try {
			UserView userView = securityService.login(accessNumber, pinNumber);
			fail("���҂��Ă�����O���������܂���ł���");
		} catch(InvalidLoginException e) {
			assertThat(e.getMessage(), is("Mismatch input value " + accessNumber + ":" + pinNumber));
		}
	}

}

package com.oreilly.struts.banking.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.oreilly.struts.banking.exception.InvalidLoginException;
import com.oreilly.struts.banking.view.UserView;

public class SecurityServiceTest {

	private SecurityService securityService = new SecurityService();
	
	@Test
	private void 正常なログイン処理() throws InvalidLoginException {
		String accessNumber = "123456789";
		String pinNumber = "1111";
		UserView userView = securityService.login(accessNumber, pinNumber);
		
		String expected = "田中";
		String actual = userView.getName();
		
		assertThat(actual, is(expected));
	}

}

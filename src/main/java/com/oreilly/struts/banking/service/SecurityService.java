package com.oreilly.struts.banking.service;

import com.oreilly.struts.banking.entity.account.Account;
import com.oreilly.struts.banking.entity.account.AccountMgr;
import com.oreilly.struts.banking.entity.member.Member;
import com.oreilly.struts.banking.entity.member.MemberMgr;
import com.oreilly.struts.banking.exception.InvalidLoginException;
import com.oreilly.struts.banking.view.UserView;

import net.sf.hibernate.HibernateException;

public class SecurityService implements IAuthentication{
	
	public UserView login( String accessNumber, String pin) throws InvalidLoginException, HibernateException {
		UserView userView = null;

			Member member = new MemberMgr().find(accessNumber);
			
			Account account = new AccountMgr().find(member.getId());

			if(!(pin.equals(member.getPinNumber()))) {
				String msg = "Mismatch input value " + accessNumber + ":" + pin;
				throw new InvalidLoginException( msg );
			}
			else {
				userView = new UserView(member.getId(), member.getName(), account.getBalance());
			}

			return userView;
	}
}

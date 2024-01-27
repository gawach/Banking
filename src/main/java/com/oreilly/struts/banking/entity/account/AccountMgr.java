package com.oreilly.struts.banking.entity.account;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class AccountMgr {
	public Account select() throws HibernateException {
		
		Account account = null;
		
		Configuration config = new Configuration();
		config = config.configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		List list = session.createCriteria(Account.class).list();
		
		for (int i = 0; i < list.size(); i++) {
			if(i != 0) {
				break;
			}
			account = (Account)list.get(i);
			System.out.println("");
			System.out.println(account.getId()
					+ "," + account.getBalance()
					+ "," + account.getMemberId()
					);
		}
		
		return account;
	}
	
	public Account find(int memberId) throws HibernateException {
		
		Account account = null;
		
		Configuration config = new Configuration();
		config = config.configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String sql = "from Account as acc";
		sql += " where acc.memberId = " + memberId;
		
		List list = session.find(sql);
		
		for (int i = 0; i < list.size(); i++) {
			if(i != 0) {
				break;
			}
			account = (Account)list.get(i);
			System.out.println("");
			System.out.println(account.getId()
					+ "," + account.getBalance()
					+ "," + account.getMemberId()
					);
		}
		
		return account;
	}
}

package com.oreilly.struts.banking.entity.member;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

public class MemberMgr {
	
	public Member select() throws HibernateException {
		Member member = new Member();
		Configuration config = new Configuration();
		config = config.configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		List list = session.createCriteria(Member.class).list();
		for (int i = 0; i < list.size(); i++) {
			member = (Member)list.get(i);
			System.out.println("");
			System.out.println(member.getId()
					+ "," + member.getName()
					+ "," + member.getEmail()
					+ "," + member.getPassword()
					+ "," + member.getCategory()
					);
		}
		
		return member;
	}
	
	public Member find(String accessNumber) throws HibernateException {
		Member member = null;
		
		Configuration config = new Configuration();
		config = config.configure();

		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
			String sql = "from Member as mem";
			sql += " where mem.accessNumber = " + accessNumber;
			
			List list = session.find(sql);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0) {
					break;
				}
				member = (Member)list.get(i);
				System.out.println("");
				System.out.println(member.getId()
						+ "," + member.getName()
						+ "," + member.getEmail()
						+ "," + member.getPassword()
						+ "," + member.getCategory()
						+ "," + member.getAccessNumber()
						+ "," + member.getPinNumber()
						);
			}
			return member;
	}
	
}

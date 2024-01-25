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
		config = config.configure(); // 設定の読み込み
		// セッションファクトリーの作成
		SessionFactory sessionfactory = config.buildSessionFactory();
		// セッションオープン
		Session session = sessionfactory.openSession();
		// Memberテーブルの全件検索
		List list = session.createCriteria(Member.class).list();
		for (int i = 0; i < list.size(); i++) {
			// レコードとなるMemberオブジェクトを取得
			member = (Member)list.get(i);
			// IDとDISPLAYLABEL列のデータを表示
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
		config = config.configure(); // 設定の読み込み
		// セッションファクトリーの作成
		SessionFactory sessionfactory = config.buildSessionFactory();
		// セッションオープン
		Session session = sessionfactory.openSession();
	// SQLの生成
			String sql = "from Member as mem";
			// WHERE句の追加
			sql += " where mem.accessNumber = " + accessNumber;
			
			// SQLの実行
			List list = session.find(sql);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0) {
					break;
				}
				// レコードとなるMemberオブジェクトを取得
				member = (Member)list.get(i);
				// データを表示
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

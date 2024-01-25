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
		// 設定の読み込み
		config = config.configure();
		// セッションファクトリーの作成
		SessionFactory sessionfactory = config.buildSessionFactory();
		// セッションオープン
		Session session = sessionfactory.openSession();
		// Memberテーブルの全件検索
		List list = session.createCriteria(Account.class).list();
		
		for (int i = 0; i < list.size(); i++) {
			if(i != 0) {
				break;
			}
			// レコードとなるMemberオブジェクトを取得
			account = (Account)list.get(i);
			// データを表示
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
		config = config.configure(); // 設定の読み込み
		// セッションファクトリーの作成
		SessionFactory sessionfactory = config.buildSessionFactory();
		// セッションオープン
		Session session = sessionfactory.openSession();
		// SQLの生成
		String sql = "from Account as acc";
		// WHERE句の追加
		sql += " where acc.memberId = " + memberId;
		
		// SQLの実行
		List list = session.find(sql);
		
		for (int i = 0; i < list.size(); i++) {
			if(i != 0) {
				break;
			}
			// レコードとなるaccountオブジェクトを取得
			account = (Account)list.get(i);
			// データを表示
			System.out.println("");
			System.out.println(account.getId()
					+ "," + account.getBalance()
					+ "," + account.getMemberId()
					);
		}
		
		return account;
	}
}

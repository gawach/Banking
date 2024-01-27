package com.oreilly.struts.banking.service;

import com.oreilly.struts.banking.entity.account.Account;
import com.oreilly.struts.banking.entity.account.AccountMgr;
import com.oreilly.struts.banking.entity.member.Member;
import com.oreilly.struts.banking.entity.member.MemberMgr;
import com.oreilly.struts.banking.exception.InvalidLoginException;
import com.oreilly.struts.banking.view.UserView;

public class SecurityService implements IAuthentication{
	
	public UserView login( String accessNumber, String pin) throws InvalidLoginException {
		UserView userView = null;

		try {
			// ユーザーの取得
			Member member = new MemberMgr().find(accessNumber);
			
			// 口座の取得
			Account account = new AccountMgr().find(member.getId());

			// 値の検証
			if(!(pin.equals(member.getPinNumber()))) {
				// ログイン方法が正しくない場合、InvalidExceptionを発生させる
				// ログファイルに挿入するメッセージを生成する
				String msg = "Invalid Login Attempt by " + accessNumber + ":" + pin;
				throw new InvalidLoginException( msg );
			}
			else {
				userView = new UserView(member.getId(), member.getName(), account.getBalance());
			}
		} catch(Exception e) {
			//throw new InvalidLoginException("口座の取得に失敗しました。");
			e.printStackTrace();
		} finally {
			return userView;
		}
	}
}

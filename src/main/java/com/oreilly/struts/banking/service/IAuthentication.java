package com.oreilly.struts.banking.service;

import com.oreilly.struts.banking.view.UserView;

/**
 * バンキングセキュリティサービスが実装すべきメソッドを提供する
 */
public interface IAuthentication {
	/**
	 * ユーザがオンラインバンキングアプリケーションにログインするときに、
	 * loginメソッドは呼び出される
	 * @param accessNumber- 口座アクセス番号
	 * @param pin- 口座暗証番号
	 * @returns ユーザの個人データを表現するDTOオブジェクト
	 * @throws InvalidLoginException 身元証明が正しくない場合
	 */
	public UserView login( String accessNumber, String pin)
	  throws InvalidLoginException;

}

package com.dmg.jsp.member.model.exception;

/*
 * DMG.COM 회원관련 에러 처리
 * 2019.06.02
 */
public class MemberException extends Exception{

	public MemberException() {
		super();
	}
	
	public MemberException(String msg) {
		super(msg);
	}
}

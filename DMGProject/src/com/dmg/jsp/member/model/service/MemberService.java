package com.dmg.jsp.member.model.service;
import java.sql.Connection;

import com.dmg.jsp.member.model.dao.MemberDao;
import com.dmg.jsp.member.model.exception.MemberException;
import com.dmg.jsp.member.model.vo.Member;

import static com.dmg.jsp.common.JDBCTemplate.*;

public class MemberService {
	
	private Connection con;
	private MemberDao mDao = new MemberDao();
	
	public int insertMember(Member m) throws MemberException {
		
		con = getConnection();
		int result = mDao.insertMember(con, m);
		
		if(result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public Member selectMember(Member m) throws MemberException {
		
		con = getConnection();
		
		Member result = mDao.selectMember(con, m);
		
		
		close(con);
		
		if(result == null) {
			throw new MemberException("회원 아이디나 비밀번호가 올바르지 않습니다.");
		}
		
		
		return result;
	}
	
	public int updateMember(Member m) throws MemberException {
		
		con = getConnection();
		
		int result = mDao.updateMember(con, m);
		
		if(result > 0 ) {
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int deleteMember(String userId) throws MemberException {
		
		con = getConnection();
		int result = mDao.deleteMember(con, userId);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public int idDupCheck(String id) {
		con = getConnection();
		int result = mDao.idDupCheck(con, id);
		close(con);
		return result;
	}

	public int nickDupCheck(String nick) {
		con = getConnection();
		int result = mDao.nickDupCheck(con, nick);
		close(con);
		return result;
	}

}
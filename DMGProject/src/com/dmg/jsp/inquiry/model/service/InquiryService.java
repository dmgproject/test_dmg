package com.dmg.jsp.inquiry.model.service;

import static com.dmg.jsp.common.JDBCTemplate.close;
import static com.dmg.jsp.common.JDBCTemplate.commit;
import static com.dmg.jsp.common.JDBCTemplate.getConnection;
import static com.dmg.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.dmg.jsp.inquiry.model.dao.InquiryDao;
import com.dmg.jsp.inquiry.model.vo.Inquiry;

public class InquiryService {
	
	private InquiryDao iDao = new InquiryDao();

	public ArrayList<Inquiry> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Inquiry> list = iDao.selectList(con, currentPage, limit);
		
		close(con);
		
		
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = iDao.getListCount(con);
		close(con);
		
		return listCount;
	}

	public int insertInquiry(Inquiry i) {
		Connection con = getConnection();
		
		int result = iDao.insertInquiry(con, i);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		return result;
	}

	public Inquiry selectOne(int ino) {
		Connection con = getConnection();
		
		Inquiry i = iDao.selectOne(con, ino);
		
		close(con);
	
		return i;
	}

	
}



















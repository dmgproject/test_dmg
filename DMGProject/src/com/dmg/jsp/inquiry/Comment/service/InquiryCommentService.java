package com.dmg.jsp.inquiry.Comment.service;

import static com.dmg.jsp.common.JDBCTemplate.close;
import static com.dmg.jsp.common.JDBCTemplate.commit;
import static com.dmg.jsp.common.JDBCTemplate.getConnection;
import static com.dmg.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.dmg.jsp.inquiry.Comment.dao.InquiryCommentDao;
import com.dmg.jsp.inquiry.Comment.model.vo.InquiryComment;

public class InquiryCommentService {
	
	private InquiryCommentDao icDao = new InquiryCommentDao();

	public int insertComment(InquiryComment ico) {
		Connection con = getConnection();
		
		
		int result = icDao.insertComment(con, ico);
		
		if(result > 0)commit(con);
		else rollback(con);
		
		close(con);
		
		
		return result;
	}

	public ArrayList<InquiryComment> selectList(int ino) {
		Connection con = getConnection();
		ArrayList<InquiryComment> clist
		= icDao.selectList(con, ino);
		
		
		return clist;
	}

}









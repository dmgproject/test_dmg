package com.dmg.jsp.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.dmg.jsp.notice.model.dao.NoticeDao;
import com.dmg.jsp.notice.model.exception.NoticeException;
import com.dmg.jsp.notice.model.vo.Notice;
import static com.dmg.jsp.common.JDBCTemplate.*;
/*
 * DMG.COM 
 * 2019.06.01
 */
public class NoticeService {
	
	private NoticeDao nDao = new NoticeDao();

	public ArrayList<Notice> selectList(int currentPage, int limit) throws NoticeException {
		
		Connection con = getConnection();
		ArrayList<Notice> list = nDao.selectList(con);

		close(con);
		
		return list;
	}

	public int insertNotice(Notice n) throws NoticeException {
		Connection con = getConnection();
		
		int result = nDao.insertNotice(con, n);

		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public Notice selectOne(int nno) throws NoticeException {
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con, nno);
		if( n != null ) {
			
			int result = nDao.updateReadCount(con, nno);
			
			if( result > 0) commit(con);
			else rollback(con);
			
		}
		
		close(con);
		
		return n;
	}

	public Notice updateView(int nno) throws NoticeException {
		
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con, nno);
		
		close(con);
		
		return n;
	}

	public int updateNotice(Notice n) throws NoticeException {
		
		Connection con = getConnection();
		
		int result = nDao.updateNotice(con, n);
		
		if( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		
		return result;
	}

	public int deleteNotice(int nno) throws NoticeException {
		
		Connection con = getConnection();
		
		int result = nDao.deleteNotice(con, nno);
		
		if( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Notice> searchNotice(String category, String keyword) throws NoticeException {
		Connection con = getConnection();
		ArrayList<Notice> list = null;

		list = (category.length() > 0) ? 
				nDao.searchNotice(con, category, keyword) : nDao.selectList(con); 
		
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = nDao.getListCount(con);
		
		close(con);
		return listCount;
	}
	

}

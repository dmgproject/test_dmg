package com.dmg.jsp.recipe.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import static com.dmg.jsp.common.JDBCTemplate.*;

import com.dmg.jsp.recipe.model.exception.RecipeException;
import com.dmg.jsp.recipe.model.vo.Attachment;
import com.dmg.jsp.recipe.model.vo.Recipe;
import com.dmg.jsp.recipe.model.vo.RecipeSub;

public class RecipeDao {
	private Properties prop = new Properties();

	public RecipeDao() {
		String filePath = RecipeDao.class.getResource("/config/recipe-query.properties").getPath();

		try {

			prop.load(new FileReader(filePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int insertThumbnail(Connection con, Recipe r) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertRecipe");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, r.getRemain());
			pstmt.setString(2, r.getResub());
			pstmt.setString(3, r.getRename());
			pstmt.setString(4, r.getRecipe());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectCurrentBno(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = prop.getProperty("selectLastRenum");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next())
				result = rset.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	public int insertAttachment(Connection con, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertAttachment");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, at.getRenum());
			pstmt.setString(2, at.getOriginname());
			pstmt.setString(3, at.getChangename());
			pstmt.setString(4, at.getFilepath());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertSub(Connection con, RecipeSub rcs) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertSub");
		String sub[] = rcs.getResub().split(", ");
		String subCount[] = rcs.getRecount().split(", ");

		try {

			if (sub.length == subCount.length) {

				pstmt = con.prepareStatement(sql);
				for (int i = 0; i < sub.length; i++) {
					pstmt.setInt(1, rcs.getRenum());
					pstmt.setString(2, sub[i]);
					pstmt.setString(3, subCount[i]);

					result += pstmt.executeUpdate();
				}

			} else {

				System.out.println("부재료 입력 오류 - 부재료와 수량 확인");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Recipe> selectList(Connection con, int currentPage, int limit) throws RecipeException {
		ArrayList<Recipe> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {

			pstmt = con.prepareStatement(sql);

			int startRow = (currentPage - 1) * limit + 1; // 1, 11

			int endRow = startRow + limit - 1; // 10, 20

			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<Recipe>();

			while (rset.next()) {

				Recipe r = new Recipe();

				r.setRenum(rset.getInt("RENUM"));
				r.setRemain(rset.getString("REMAIN"));
				r.setRename(rset.getString("RE_NAME"));
				r.setRecipe(rset.getString("RECIPE"));
				r.setRecipefile(rset.getString("CHANGENAME"));
				r.setUploaddate(rset.getDate("UPLOADDATE"));

				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCount");

		try {

			stmt = con.createStatement();

			rset = stmt.executeQuery(sql);

			if (rset.next()) {

				listCount = rset.getInt(1);

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public HashMap<String, Object> selectThumbnailMap(Connection con, int renum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment att = null;
		Recipe r = null;
		
		HashMap<String, Object> hmap = null;

		String sql = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, renum);

			rset = pstmt.executeQuery();

			att = new Attachment();

			

			while (rset.next()) {

				r = new Recipe();

				r.setRenum(rset.getInt("RENUM"));
				r.setRemain(rset.getString("REMAIN"));
				r.setRename(rset.getString("RE_NAME"));
				r.setRecipe(rset.getString("RECIPE"));
				r.setUploaddate(rset.getDate("UPLOADDATE"));

				att.setRenum(rset.getInt("RENUM"));
				att.setFno(rset.getInt("FNO"));
				att.setOriginname(rset.getString("ORIGINNAME"));
				att.setChangename(rset.getString("CHANGENAME"));
				att.setFilepath(rset.getString("FILEPATH"));
				att.setUploaddate(rset.getDate("UPLOADDATE"));

				

				System.out.println("dao att : " + att.getRenum());
				System.out.println("dao r : " + r.getRenum());
				

			}

			hmap = new HashMap<String, Object>();

			hmap.put("recipe", r);
			hmap.put("attachment", att);
			

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}

		return hmap;
	}

	public ArrayList<RecipeSub> selectRecipSub(Connection con, int renum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RecipeSub rcs = null;
		ArrayList<RecipeSub> list = null;

		String sql = prop.getProperty("selectOneRecipeSub");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, renum);

			rset = pstmt.executeQuery();

			list = new ArrayList<RecipeSub>();

			while (rset.next()) {

				rcs = new RecipeSub();

				rcs.setRenum(renum);
				rcs.setResub(rset.getString("RESUB"));
				rcs.setRecount(rset.getString("RECOUNT"));

				System.out.println(rcs.getResub());

				list.add(rcs);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(rset);
			close(pstmt);

		}

		return list;
	}

	public int deleteRecipe(Connection con, int renum) {
		int result = 0;

		String sql = prop.getProperty("deleteRecipe");

		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, renum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);

		}

		return result;
	}

	public int deleteRecipeSub(Connection con, int renum) {
		int result = 0;

		String sql = prop.getProperty("deleteRecipeSub");

		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, renum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);

		}

		return result;
	}

	public int deleteAttachment(Connection con, int renum) {
		int result = 0;

		String sql = prop.getProperty("deleteAttachment");

		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, renum);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);

		}

		return result;
	}

	public int updateRecipe(Connection con, Recipe r) throws RecipeException {
		PreparedStatement pstmt = null;

		int result = 0;

		String sql = prop.getProperty("updateRecipe");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, r.getRemain());
			pstmt.setString(2, r.getRename());
			pstmt.setString(3, r.getRecipe());
			pstmt.setInt(4, r.getRenum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);

		}

		return result;
	}

	public int updateAttachment(Connection con, Attachment am) throws RecipeException {
		PreparedStatement pstmt = null;

		int result = 0;

		String sql = prop.getProperty("updateAttachment");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, am.getOriginname());
			pstmt.setString(2, am.getChangename());
			pstmt.setInt(3, am.getRenum());

			System.out.println(am.getOriginname());
			System.out.println(am.getChangename());
			System.out.println(am.getRenum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);

		}

		return result;
	}

	public int updateRecipeSub(Connection con, RecipeSub rcs, Recipe r) throws RecipeException {
		PreparedStatement pstmt = null;

		int result = 0;

		String sql = prop.getProperty("updateRecipeSub");
		String sub[] = rcs.getResub().split(", ");
		String subCount[] = rcs.getRecount().split(", ");
		
		System.out.println("update resub  : " + rcs.getResub());
		System.out.println("update subCount : " + rcs.getRecount());

		try {

			if (sub.length == subCount.length) {

				pstmt = con.prepareStatement(sql);

				for (int i = 0; i < sub.length; i++) {

					pstmt.setInt(1, r.getRenum());
					pstmt.setString(2, sub[i]);
					pstmt.setString(3, subCount[i]);

					result += pstmt.executeUpdate();

				}
				
			} else {
				
				System.out.println("부재료 입력 오류 - 부재료와 수량을 확인하세요");
				
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close(pstmt);

		}
		return result;
	}

}

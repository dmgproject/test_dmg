package com.dmg.jsp.recipe.model.service;

import com.dmg.jsp.recipe.model.dao.RecipeDao;
import com.dmg.jsp.recipe.model.exception.RecipeException;
import com.dmg.jsp.recipe.model.vo.Attachment;
import com.dmg.jsp.recipe.model.vo.Recipe;
import com.dmg.jsp.recipe.model.vo.RecipeSub;

import static com.dmg.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class RecipeService {

	private RecipeDao rDao = new RecipeDao();

	public int insertThumbnail(Recipe r, Attachment at, RecipeSub rcs) {
		Connection con = getConnection();
		int result = 0;

		int result1 = rDao.insertThumbnail(con, r);
		if (result1 > 0) {
			int renum = rDao.selectCurrentBno(con);
			at.setRenum(renum);
			rcs.setRenum(renum);
		}
		int result2 = rDao.insertSub(con, rcs);
		int result3 = rDao.insertAttachment(con, at);
		if (result1 > 0 && result2 > 0 && result3 > 0) {
			commit(con);
			result = 1;
		} else rollback(con);
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		
		close(con);

		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = rDao.getListCount(con);

		close(con);

		return listCount;
	}

	public ArrayList<Recipe> selectList(int currentPage, int limit) throws RecipeException {
		Connection con = getConnection();

		ArrayList<Recipe> list = rDao.selectList(con, currentPage, limit);

		close(con);

		return list;
	}

	public HashMap<String, Object> selectThumbnailMap(int renum) {
		Connection con = getConnection();
		HashMap<String, Object> hmap = null;
		
		hmap = rDao.selectThumbnailMap(con, renum);
		
		close(con);
				
		return hmap;
	}

	public ArrayList<RecipeSub> selectRecipSub(int renum) {
		Connection con = getConnection();
		
		ArrayList<RecipeSub> list = null;
		
		list = rDao.selectRecipSub(con, renum);
		
		close(con);
		
		return list;
	}

	public int deleteRecipe(int renum) {
		Connection con = getConnection();
		
		int result = 0;
		
		int result2 = rDao.deleteRecipeSub(con, renum);
		
		int result3 = rDao.deleteAttachment(con, renum);
		
		int result1 = rDao.deleteRecipe(con, renum);
		
		if( result2 > 0 && result3 > 0) {
			
			if( result1 > 0) {
				
				commit(con);
				
				result = 1;
				
			}else rollback(con);
			
		} 
		
		
		close(con);
		
		
		
		return result;
	}

	public int updateRecipe(Recipe r, Attachment am, RecipeSub rcs) throws RecipeException {
		Connection con = getConnection();
		
		int result = 0;
		
		int result1 = rDao.updateRecipe(con, r);
		
		System.out.println("resutl1" + result1);
		
		if(result1 > 0) {
			
			int result2 = rDao.updateAttachment(con, am);
			
			System.out.println("result2"+result2);
			
			if(result2 > 0) {
				
				int result3 = rDao.deleteRecipeSub(con, r.getRenum());
				
				System.out.println("result3"+result3);
				
				if(result3 > 0) {
					
					int result4 = rDao.updateRecipeSub(con, rcs, r);
					
					if(result4 > 0) {
						commit(con);
						result = 1;
					} else rollback(con);
					
				}
	
			}
			
		}
		
		close(con);
		
		return result;
	}

	

}

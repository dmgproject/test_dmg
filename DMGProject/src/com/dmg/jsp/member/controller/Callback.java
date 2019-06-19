package com.dmg.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dmg.jsp.member.model.vo.Member;
import com.google.gson.Gson;


import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

@WebServlet("/callback.me")
public class Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Callback() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("콜백.me");
	    String clientId = "3_Nv4pf63XY2WISxV507";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "WkKPxvRYj5";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://127.0.0.1:8088/DMG/index.jsp", "UTF-8");
	    String apiURL;
	    System.out.println(state);
	    System.out.println("1");
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    System.out.println("2");
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	    try {
	      System.out.println("3");
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.println("4");
	      System.out.println("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	    	System.out.println("정상 호출");
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	    	System.out.println("호출 에러");
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      System.out.println("5");
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	    	  System.out.println("6");
	    	  System.out.print(res.toString());
	    	  // ******
	    	  //HashMap<String, String> resMap = new HashMap<String, String>();
	    	  //Gson gson = new Gson();
	    	  //resMap = new gson.fromJson(res, resMap.getclass);
	    	  //resMap = gson.toJson(res, resMap.getClass());
	    	  //resMap = (HashMap<String, String>) gson.toJson(res, resMap.getClass());
	    	  JSONParser parsing = new JSONParser();
	    	  Object obj = parsing.parse(res.toString());
	    	  JSONObject jsonobj = (JSONObject)obj;
	    	  access_token = (String)jsonobj.get("access_token");
	    	  refresh_token= (String)jsonobj.get("refresh_token");
	    	  System.out.println("\n----------------------------");
	    	  System.out.println("access_token=" + access_token);
	    	  System.out.println("refresh_token=" +refresh_token);
	    	  String[] obk = new String[2];
	    	  NaverLogin lg = new NaverLogin();
	    	  obk = lg.NaverLogins(access_token);
	    	  // ------------------------------------------------------------------------- //
	    	  System.out.println(obk[0]);
	    	  System.out.println(obk[1]);
	    	  
	    	  
	    	  Member m = new Member(obk[0], obk[1], obk[1]);
	    	  HttpSession session = request.getSession();
	    	  session.setAttribute("member", m);
	    	  PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('" + m.getEmail() + " 님 환영합니다!" + "');");
				out.println("location.href='index.jsp'");
				//out.println("opener.location.reload();");
				out.println("window.close();");
				out.println("</script>");
				out.close();
	    	  
	    	  
	    	  
	      }
	    } catch (Exception e) {
	      System.out.println("Exception");
	      System.out.println(e);
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

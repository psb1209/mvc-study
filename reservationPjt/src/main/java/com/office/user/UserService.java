package com.office.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserService {

	final private String CLASS_NAME = "[UserService] ";
	
	final static public int USER_REGIST_SUCCESS 	= 1;
	final static public int USER_REGIST_FAIL 		= 0;
	
	final static public int USER_LOGIN_SUCCESS 		= 1;
	final static public int USER_LOGIN_FAIL 		= 0;
	
	final static public boolean USER_LOGINED_SESSION_FLAG_FALSE = false;
	final static public boolean USER_LOGINED_SESSION_FLAG_TRUE 	= true;
	
	final static public int USER_MODIFY_SUCCESS 	= 1;
	final static public int USER_MODIFY_FAIL 		= 0;
	
	final static public int USER_DELETE_SUCCESS 	= 1;
	final static public int USER_DELETE_FAIL 		= 0;
	
	final private UserDao userDao = new UserDao();
	
	public int userRegistConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("userRegistConfirm()"));
		
		String uID = request.getParameter("uID");
		String uPW = request.getParameter("uPW");
		String uGender = request.getParameter("uGender");
		String uMail = request.getParameter("uMail");
		String uPhone = request.getParameter("uPhone");
		
		// ID 중복 체크 & 회원가입
		boolean isMember = userDao.selectUserByUID(uID);		// true || false
		if (!isMember) {
			UserDto userDto = new UserDto(uID, uPW, uGender, uMail, uPhone);
			int result = userDao.insertUser(userDto);
			
			if (result > 0) {
				System.out.println(CLASS_NAME.concat("USER REGIST SUCCESS!!"));
				return USER_REGIST_SUCCESS;
				
			} else {
				System.out.println(CLASS_NAME.concat("USER REGIST FAIL!!"));
				return USER_REGIST_FAIL;
				
			}
			
		} else {
			System.out.println(CLASS_NAME.concat("USER REGIST FAIL!!"));
			return USER_REGIST_FAIL;
			
		}
		
	}

	public int userLoginConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("userLoginConfirm()"));
		
		String uID = request.getParameter("uID");
		String uPW = request.getParameter("uPW");
		
		UserDto userDto = new UserDto(uID, uPW);
		
		UserDto loginedUserDto = userDao.selectUserByIdAndPw(userDto);
		
		if (loginedUserDto != null) {
			System.out.println(CLASS_NAME.concat("USER LOGIN SUCCESS!!"));
			
			HttpSession session = request.getSession();
			session.setAttribute(UserConfig.USER_ID_AT_SESSION, loginedUserDto.getuID());
			session.setMaxInactiveInterval(60 * 30);	// 30분
			
			return USER_LOGIN_SUCCESS;
			
		} else {
			System.out.println(CLASS_NAME.concat("USER LOGIN FAIL!!"));
			
			return USER_LOGIN_FAIL;
			
		}
		
	}

	public void userLogoutConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("userLogoutConfirm()"));
		
		HttpSession session = request.getSession();
		session.invalidate();
		
	}

	public boolean userModifyForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("userModifyForm()"));
		
		HttpSession session = request.getSession();
		Object object = session.getAttribute(UserConfig.USER_ID_AT_SESSION);	// null || gildong
		
		if (object != null) {
			String loginedUserId = String.valueOf(object);		// String type gildong
			UserDto loginedUserDto = userDao.selectUserByUIDForModify(loginedUserId);
			
			request.setAttribute(UserConfig.USER_LOGINED_DTO, loginedUserDto);
			
			return USER_LOGINED_SESSION_FLAG_TRUE;
			
		} else {
			return USER_LOGINED_SESSION_FLAG_FALSE;
			
		}
		
	}

	public int userModifyConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("userModifyConfirm()"));
		
		int uNo = Integer.parseInt(request.getParameter("uNo"));
		String uPW = request.getParameter("uPW");
		String uGender = request.getParameter("uGender");
		String uMail = request.getParameter("uMail");
		String uPhone = request.getParameter("uPhone");
		
		UserDto userDto = new UserDto(uNo, uPW, uGender, uMail, uPhone);
		
		int result = userDao.updateUser(userDto);
		
		if (result > 0) {
			System.out.println(CLASS_NAME.concat("USER MODIFY SUCCESS!!"));
			return USER_MODIFY_SUCCESS;
			
		} 
		
		System.out.println(CLASS_NAME.concat("USER MODIFY FAIL!!"));
		return USER_MODIFY_FAIL;

	}

	public int userDeleteConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("userDeleteConfirm()"));
		
		HttpSession session = request.getSession();
		Object object = session.getAttribute(UserConfig.USER_ID_AT_SESSION);
		if (object != null) {
			String loginedUserId = String.valueOf(object);
			int result = userDao.deleteByUId(loginedUserId);
			
			if (result > 0) {
				System.out.println(CLASS_NAME.concat("USER DELETE SUCCESS!!"));
				
				session.invalidate();
				
				return USER_DELETE_SUCCESS;
				
			} else {
				System.out.println(CLASS_NAME.concat("USER DELETE FAIL!!"));
				return USER_DELETE_FAIL;
			}
			
		} else {
			System.out.println(CLASS_NAME.concat("USER DELETE FAIL!! -- SESSION OUT"));
			return USER_DELETE_FAIL;
			
		}
		
	}

}

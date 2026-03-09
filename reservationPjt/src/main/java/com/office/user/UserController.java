package com.office.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.office.Config;
import com.office.viewresolver.ViewResolver;


@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final private String CLASS_NAME = "[UserController] ";
	
    public UserController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		System.out.println("requestURI: " + requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath);
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command: " + command);
		
		String nextPage = null;
		UserService userService = null;
		
		switch (command) {
		case UserConfig.USER_REGIST_FORM:
			// 회원가입 폼
			System.out.println(CLASS_NAME.concat(UserConfig.USER_REGIST_FORM));
//			nextPage = "view/user_regist_form.jsp";
//			nextPage = Config.VIEW_DEFAULT_PATH
//					.concat("user_regist_form")
//					.concat(Config.VIEW_DEFAULT_EXTENTION);
			nextPage = ViewResolver.viewResolverForJSP("user_regist_form");
			break;
			
		case UserConfig.USER_LOGIN_FORM:
			// 로그인 폼
			System.out.println(CLASS_NAME.concat(UserConfig.USER_LOGIN_FORM));
//			nextPage = "view/user_login_form.jsp";
//			nextPage = Config.VIEW_DEFAULT_PATH
//					.concat("user_login_form")
//					.concat(Config.VIEW_DEFAULT_EXTENTION);
			nextPage = ViewResolver.viewResolverForJSP("user_login_form");
			break;
		
		case UserConfig.USER_REGIST_CONFIRM:
			// 회원가입 확인
			System.out.println(CLASS_NAME.concat(UserConfig.USER_REGIST_CONFIRM));
			
			userService = new UserService();
			int resultForUserRegist = userService.userRegistConfirm(request, response);
			
			switch (resultForUserRegist) {
			case UserService.USER_REGIST_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("user_regist_ok");
				break;
				
			case UserService.USER_REGIST_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("user_regist_ng");
				break;
				
			}
			
			break;
			
		case UserConfig.USER_LOGIN_CONFIRM:
			// 로그인
			System.out.println(CLASS_NAME.concat(UserConfig.USER_LOGIN_CONFIRM));
			
			userService = new UserService();
			int resultForLogin = userService.userLoginConfirm(request, response);
			
			switch (resultForLogin) {
			case UserService.USER_LOGIN_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("user_login_ok");
				break;

			case UserService.USER_LOGIN_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("user_login_ng");
				break;
			}
			
			break;
			
		case UserConfig.USER_LOGOUT_CONFIRM:
			// 로그아웃
			System.out.println(CLASS_NAME.concat(UserConfig.USER_LOGOUT_CONFIRM));
			
			userService = new UserService();
			userService.userLogoutConfirm(request, response);
			
			nextPage = "/";
			
			break;
			
		case UserConfig.USER_MODIFY_FORM:
			// 정보 수정
			System.out.println(CLASS_NAME.concat(UserConfig.USER_MODIFY_FORM));
			
			userService = new UserService();
			boolean isSession = userService.userModifyForm(request, response);
			
			if (isSession) {
				nextPage = ViewResolver.viewResolverForJSP("user_modify_form");
				
			} else {
				nextPage = "/";
				
			}
			
			break;
			
		case UserConfig.USER_MODIFY_CONFIRM:
			// 정보 수정 확인
			System.out.println(CLASS_NAME.concat(UserConfig.USER_MODIFY_CONFIRM));
			
			userService = new UserService();
			int resultForModify = userService.userModifyConfirm(request, response);
			
			switch (resultForModify) {
			case UserService.USER_MODIFY_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("user_modify_ok");
				break;

			case UserService.USER_MODIFY_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("user_modify_ng");
				break;
			}
			
			break;
			
		case UserConfig.USER_DELETE_CONFIRM:
			// 계정 삭제
			System.out.println(CLASS_NAME.concat(UserConfig.USER_DELETE_CONFIRM));
			
			userService = new UserService();
			int resultForDelete = userService.userDeleteConfirm(request, response);
			
			switch (resultForDelete) {
			case UserService.USER_DELETE_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("user_delete_ok");
				break;

			case UserService.USER_DELETE_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("user_delete_ng");
				
				break;
			}
			
			break;
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(Config.ENCODING_UTF8);
		doGet(request, response);
	}

}

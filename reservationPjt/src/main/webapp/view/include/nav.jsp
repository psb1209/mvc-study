<%@page import="com.office.reservation.ReservationConfig"%>
<%@page import="com.office.user.UserConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav>

	<div class="nav_wrap">
		
		<a href="<%= request.getContextPath() %>">홈</a>
		
		<%
			Object obj = session.getAttribute(UserConfig.USER_ID_AT_SESSION);
			if (obj == null) {
		%>
				<a href="<%= request.getContextPath().concat(UserConfig.USER_REGIST_FORM) %>">회원가입</a>
				<a href="<%= request.getContextPath().concat(UserConfig.USER_LOGIN_FORM) %>">로그인</a>
		<%
			} else {
		%>
				<a href="<%= request.getContextPath().concat(UserConfig.USER_MODIFY_FORM) %>">정보수정</a>
				<a href="<%= request.getContextPath().concat(UserConfig.USER_DELETE_CONFIRM) %>">계정삭제</a>
				<a href="<%= request.getContextPath().concat(UserConfig.USER_LOGOUT_CONFIRM) %>">로그아웃</a>
				<a href="<%= request.getContextPath().concat(ReservationConfig.RESERVATION_FORM) %>">비행기예약</a>
				<a href="<%= request.getContextPath().concat(ReservationConfig.RESERVATION_LIST) %>">비행기예약목록</a>
		<%
			}
		%>
		
	</div>

</nav>
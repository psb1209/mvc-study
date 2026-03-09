<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="./css/user_regist_form.css" type="text/css" rel="stylesheet">
<script src="./js/user.js" type="text/javascript"></script>

</head>
<body>

	<%@include file="./include/header.jsp" %>
	<%@include file="./include/nav.jsp" %>

	<section>
	
		<div class="section_wrap">
			
			<div class="article">
				
				<form 	action="<%= request.getContextPath().concat(UserConfig.USER_LOGIN_CONFIRM) %>"
						method="post"
						name="user_login_form">
				
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="uID" placeholder="INPUT USER ID"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="uPW" placeholder="INPUT USER PW"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" value="로그인" onclick="userLoginForm();">
								<input type="reset" value="초기화">
							</td>
						</tr>
					</table>
					
				</form>
				
			</div>
			
		</div>
	
	</section>
	
	<%@include file="./include/footer.jsp" %>

</body>
</html>
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
				
				<form 	action="<%= request.getContextPath().concat(UserConfig.USER_MODIFY_CONFIRM) %>"
						method="post"
						name="user_modify_form">
				
					<input type="hidden" name="uNo" value="${loginedUserDto.uNo}">
				
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="uID" value="${loginedUserDto.uID}" readonly disabled></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="uPW" value="${loginedUserDto.uPW}" placeholder="INPUT NEW USER PW"></td>
						</tr>
						<tr>
							<td>성구분</td>
							<td>
								<select name="uGender">
									<option value="">-- 선택 --</option>
									<option value="M" ${loginedUserDto.uGender == 'M' ? 'selected' : '' }>남성</option>
									<option value="W" ${loginedUserDto.uGender == 'W' ? 'selected' : '' }>여성</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>메일주소</td>
							<td><input type="email" name="uMail" value="${loginedUserDto.uMail}" placeholder="INPUT NEW USER MAIL"></td>
						</tr>
						<tr>
							<td>연락처</td>
							<td><input type="text" name="uPhone" value="${loginedUserDto.uPhone}" placeholder="INPUT NEW USER PHONE"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" value="정보수정" onclick="userModifyForm();">
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
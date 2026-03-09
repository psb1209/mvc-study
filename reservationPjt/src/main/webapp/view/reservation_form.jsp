<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="./css/reservation_form.css" type="text/css" rel="stylesheet">
<script src="./js/reservation.js" type="text/javascript"></script>

</head>
<body>

	<%@include file="./include/header.jsp" %>
	<%@include file="./include/nav.jsp" %>

	<section>
	
		<div class="section_wrap">
			
			<div class="article">
				
				<form action="<%= request.getContextPath().concat(ReservationConfig.RESERVATION_CONFIRM) %>" 
					  method="post" 
					  name="reservation_form">
				
					<table>
						<tr>
							<td>예약자 이름</td>
							<td>
								<input type="text" name="rName" placeholder="INPUT RESERVATION NAME">
							</td>
						</tr>
						<tr>
							<td>예약자 메일</td>
							<td>
								<input type="text" name="rMail" placeholder="INPUT RESERVATION MAIL">
							</td>
						</tr>
						<tr>
							<td>예약자 연락처</td>
							<td>
								<input type="text" name="rPhone" placeholder="INPUT RESERVATION PHONE">
							</td>
						</tr>
						<tr>
							<td>출발지</td>
							<td>
								<select name="departLocationNo">
									<option value="">-- 출발지 선택 --</option>
									<option value="1">인천</option>
									<option value="2">김포</option>
									<option value="3">부산</option>
									<option value="4">광주</option>
									<option value="5">청주</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>출발 날짜/시간</td>
							<td>
								<input type="datetime-local" name="rDepartDateTime">
							</td>
						</tr>
						<tr>
							<td>도착지</td>
							<td>
								<select name="arrivalLocationNo">
									<option value="">-- 도착지 선택 --</option>
									<option value="1">일본</option>
									<option value="2">중국</option>
									<option value="3">호주</option>
									<option value="4">미국</option>
									<option value="5">캐나다</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>도착 날짜/시간</td>
							<td>
								<input type="datetime-local" name="rArrivalDateTime">
							</td>
						</tr>
						<tr>
							<td>성인 인원수(만 12세 이상)</td>
							<td>
								<input type="number" name="rAdultCnt">
							</td>
						</tr>
						<tr>
							<td>어린이 인원수(만 12세 미만)</td>
							<td>
								<input type="number" name="rChildCnt">
							</td>
						</tr>
						<tr>
							<td>유아 인원수(24개월 미만)</td>
							<td>
								<input type="number" name="rInfantCnt">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" value="예약하기" onclick="reservationForm();">
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
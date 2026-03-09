<%@page import="com.office.reservation.ReservationDto"%>
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
				
				<form action="<%= request.getContextPath().concat(ReservationConfig.RESERVATION_MODIFY_CONFIRM) %>" 
					  method="post" 
					  name="reservation_modify_form">
					
					<input type="hidden" name="rNo" value="${reservationDto.rNo}" />
					
					<table>
						<tr>
							<td>예약자 이름</td>
							<td>
								<input type="text" name="rName" value="${reservationDto.rName}" placeholder="INPUT RESERVATION NAME">
							</td>
						</tr>
						<tr>
							<td>예약자 메일</td>
							<td>
								<input type="text" name="rMail" value="${reservationDto.rMail}" placeholder="INPUT RESERVATION MAIL">
							</td>
						</tr>
						<tr>
							<td>예약자 연락처</td>
							<td>
								<input type="text" name="rPhone" value="${reservationDto.rPhone}" placeholder="INPUT RESERVATION PHONE">
							</td>
						</tr>
						<tr>
							<td>출발지</td>
							<td>
								<select name="departLocationNo">
									<option value="">-- 출발지 선택 --</option>
									<option value="1" ${reservationDto.departLocationNo == 1 ? 'selected' : ''}>인천</option>
									<option value="2" ${reservationDto.departLocationNo == 2 ? 'selected' : ''}>김포</option>
									<option value="3" ${reservationDto.departLocationNo == 3 ? 'selected' : ''}>부산</option>
									<option value="4" ${reservationDto.departLocationNo == 4 ? 'selected' : ''}>광주</option>
									<option value="5" ${reservationDto.departLocationNo == 5 ? 'selected' : ''}>청주</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>출발 날짜/시간</td>
							<td>
								<input type="datetime-local" value="${reservationDto.rDepartDateTime}" name="rDepartDateTime">
							</td>
						</tr>
						<tr>
							<td>도착지</td>
							<td>
								<select name="arrivalLocationNo">
									<option value="">-- 도착지 선택 --</option>
									<option value="1" ${reservationDto.arrivalLocationNo == 1 ? 'selected' : ''}>일본</option>
									<option value="2" ${reservationDto.arrivalLocationNo == 2 ? 'selected' : ''}>중국</option>
									<option value="3" ${reservationDto.arrivalLocationNo == 3 ? 'selected' : ''}>호주</option>
									<option value="4" ${reservationDto.arrivalLocationNo == 4 ? 'selected' : ''}>미국</option>
									<option value="5" ${reservationDto.arrivalLocationNo == 5 ? 'selected' : ''}>캐나다</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>도착 날짜/시간</td>
							<td>
								<input type="datetime-local" value="${reservationDto.rArrivalDateTime}" name="rArrivalDateTime">
							</td>
						</tr>
						<tr>
							<td>성인 인원수(만 12세 이상)</td>
							<td>
								<input type="number" value="${reservationDto.rAdultCnt}" name="rAdultCnt">
							</td>
						</tr>
						<tr>
							<td>어린이 인원수(만 12세 미만)</td>
							<td>
								<input type="number" value="${reservationDto.rChildCnt}" name="rChildCnt">
							</td>
						</tr>
						<tr>
							<td>유아 인원수(24개월 미만)</td>
							<td>
								<input type="number" value="${reservationDto.rInfantCnt}" name="rInfantCnt">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" value="변경하기" onclick="reservationModifyForm();">
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
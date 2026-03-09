<%@page import="com.office.reservation.ReservationDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="./css/reservation_list.css" type="text/css" rel="stylesheet">
<script src="./js/reservation.js" type="text/javascript"></script>

</head>
<body>

	<%@include file="./include/header.jsp" %>
	<%@include file="./include/nav.jsp" %>

	<section>
	
		<div class="section_wrap">
			
			<div class="article">
				
				<table>
					<thead>
						<tr>
							<th>예약번호</th>
							<th>예약자 이름</th>
							<th>예약자 메일</th>
							<th>예약자 연락처</th>
							<th>출발지</th>
							<th>출발 날짜/시간</th>
							<th>도착지</th>
							<th>도착 날짜/시간</th>
							<th>성인</th>
							<th>어린이</th>
							<th>유아</th>
							<th>예약 등록일</th>
							<th>예약 수정일</th>
							<th>변경/취소</th>
						</tr>
					</thead>
					<tbody>
					
						<%
							List<ReservationDto> reservationDtos = 
								(List<ReservationDto>) request.getAttribute("reservationDtos");
						
							for (int i = 0; i < reservationDtos.size(); i++) {
									ReservationDto dto = reservationDtos.get(i);
						%>
								<tr>
									<td><%= dto.getrNo() %></td>
									<td><%= dto.getrName() %></td>
									<td><%= dto.getrMail() %></td>
									<td><%= dto.getrPhone() %></td>
									<td><%= dto.getDepartLocationName() %></td>
									<td><%= dto.getrDepartDateTime() %></td>
									<td><%= dto.getArrivalLocationName() %></td>
									<td><%= dto.getrArrivalDateTime() %></td>
									<td><%= dto.getrAdultCnt() %></td>
									<td><%= dto.getrChildCnt() %></td>
									<td><%= dto.getrInfantCnt() %></td>
									<td><%= dto.getrRegDate() %></td>
									<td><%= dto.getrModDate() %></td>
									<td>
									<a href="<%= request.getContextPath().concat(ReservationConfig.RESERVATION_MODIFY_FORM).concat("?rNo=") %><%= dto.getrNo() %>">변경</a>
									&nbsp;|&nbsp;
									<a href="<%= request.getContextPath().concat(ReservationConfig.RESERVATION_CANCEL_CONFIRM).concat("?rNo=") %><%= dto.getrNo() %>">취소</a>
									</td>
								</tr>			
						<%
							}
						
						%>
					
						
					</tbody>
				</table>
				
			</div>
			
		</div>
	
	</section>
	
	<%@include file="./include/footer.jsp" %>

</body>
</html>
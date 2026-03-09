package com.office.reservation;

import java.util.List;

import com.office.user.UserConfig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReservationService {

	final private String CLASS_NAME = "[ReservationService] ";
	
	final static public byte RESERVATION_SUCCESS 	= 1;
	final static public byte RESERVATION_FAIL 		= 0;
	
	final static public byte RESERVATION_MODIFY_SUCCESS 	= 1;
	final static public byte RESERVATION_MODIFY_FAIL 		= 0;
	
	final static public byte RESERVATION_CANCEL_SUCCESS 	= 1;
	final static public byte RESERVATION_CANCEL_FAIL 		= 0;
	
	private ReservationDao reservationDao = new ReservationDao();

	public int reservationConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("reservationConfirm()"));
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(UserConfig.USER_ID_AT_SESSION);
		
		if (obj != null) {
			
			String uID = String.valueOf(obj);
			String rName = request.getParameter("rName");
			String rMail = request.getParameter("rMail");
			String rPhone = request.getParameter("rPhone");
			int departLocationNo = Integer.parseInt(request.getParameter("departLocationNo"));
			String rDepartDateTime = request.getParameter("rDepartDateTime");
			int arrivalLocationNo = Integer.parseInt(request.getParameter("arrivalLocationNo"));
			String rArrivalDateTime = request.getParameter("rArrivalDateTime");
			int rAdultCnt = Integer.parseInt(request.getParameter("rAdultCnt"));
			int rChildCnt = Integer.parseInt(request.getParameter("rChildCnt"));
			int rInfantCnt = Integer.parseInt(request.getParameter("rInfantCnt"));
			
			ReservationDto reservationDto = new ReservationDto(
					0, uID, rName, rMail, rPhone, departLocationNo, 
					rDepartDateTime, arrivalLocationNo, 
					rArrivalDateTime, rAdultCnt, rChildCnt, rInfantCnt, 
					null, null, null, null);
			
			int result = reservationDao.insertReservation(reservationDto);
			if (result > 0) {
				System.out.println(CLASS_NAME.concat("RESERVATION SUCCESS!!"));
				return RESERVATION_SUCCESS;
				
			} else {
				System.out.println(CLASS_NAME.concat("RESERVATION FAIL!!"));
				return RESERVATION_FAIL;
				
			}
			
		} else {
			System.out.println(CLASS_NAME.concat("RESERVATION FAIL!! -- SESSION OUT"));
			return RESERVATION_FAIL;
			
		}
		
	}

	public void reservationList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("reservationList()"));
		
		HttpSession session = request.getSession();
		String loginedUserId = String.valueOf(session.getAttribute(UserConfig.USER_ID_AT_SESSION));
		
		List<ReservationDto> reservationDtos = reservationDao.selectReservations(loginedUserId);
		request.setAttribute("reservationDtos", reservationDtos);
		
	}

	public void reservationModifyForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("reservationModifyForm()"));
		
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		ReservationDto reservationDto = reservationDao.selectReservationByRNo(rNo);
		
		request.setAttribute("reservationDto", reservationDto);
		
	}

	public int reservationModifyConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("reservationModifyConfirm()"));
		
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		String rName = request.getParameter("rName");
		String rMail = request.getParameter("rMail");
		String rPhone = request.getParameter("rPhone");
		int departLocationNo = Integer.parseInt(request.getParameter("departLocationNo"));
		String rDepartDateTime = request.getParameter("rDepartDateTime");
		int arrivalLocationNo = Integer.parseInt(request.getParameter("arrivalLocationNo"));
		String rArrivalDateTime = request.getParameter("rArrivalDateTime");
		int rAdultCnt = Integer.parseInt(request.getParameter("rAdultCnt"));
		int rChildCnt = Integer.parseInt(request.getParameter("rChildCnt"));
		int rInfantCnt = Integer.parseInt(request.getParameter("rInfantCnt"));
		
		ReservationDto reservationDto = new ReservationDto(rNo, null, rName, rMail, rPhone, departLocationNo, rDepartDateTime, 
				arrivalLocationNo, rArrivalDateTime, rAdultCnt, rChildCnt, rInfantCnt, 
				null, null, null, null);
		
		int result = reservationDao.updateReservation(reservationDto);
		
		if (result > 0) {
			System.out.println(CLASS_NAME.concat("RESERVATION MODIFY SUCCESS!!"));
			return RESERVATION_MODIFY_SUCCESS;
			
		} else {
			System.out.println(CLASS_NAME.concat("RESERVATION MODIFY FAIL!!"));
			return RESERVATION_MODIFY_FAIL;
			
		}
		
	}

	public int reservationCancelConfirm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(CLASS_NAME.concat("reservationCancelConfirm()"));
		
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		int result = reservationDao.deleteByRNo(rNo);
		
		if (result > 0) {
			System.out.println(CLASS_NAME.concat("RESERVATION CANCEL SUCCESS!!"));
			return RESERVATION_CANCEL_SUCCESS;
			
		} else {
			System.out.println(CLASS_NAME.concat("RESERVATION CANCEL FAIL!!"));
			return RESERVATION_CANCEL_FAIL;
			
		}
		
	}
	
}

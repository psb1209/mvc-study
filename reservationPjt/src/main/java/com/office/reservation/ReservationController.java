package com.office.reservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.office.Config;
import com.office.viewresolver.ViewResolver;


@WebServlet("*.air")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final private String CLASS_NAME = "[ReservationController] ";

    public ReservationController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ReservationService reservationService = null;
		String nextPage = null;
		
		switch (command) {
		case ReservationConfig.RESERVATION_FORM:
			// 예약 양식
			System.out.println(CLASS_NAME.concat(ReservationConfig.RESERVATION_FORM));
			
			nextPage = ViewResolver.viewResolverForJSP("reservation_form");
			
			break;
			
		case ReservationConfig.RESERVATION_CONFIRM:
			// 예약 확인
			System.out.println(CLASS_NAME.concat(ReservationConfig.RESERVATION_CONFIRM));
			
			reservationService = new ReservationService();
			int resultForReservation = reservationService.reservationConfirm(request, response);
			
			switch (resultForReservation) {
			case ReservationService.RESERVATION_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("reservation_ok");
				break;

			case ReservationService.RESERVATION_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("reservation_ng");
				break;
			}
			
			break;
			
		case ReservationConfig.RESERVATION_LIST:
			// 예약 목록
			System.out.println(CLASS_NAME.concat(ReservationConfig.RESERVATION_LIST));
			
			reservationService = new ReservationService();
			reservationService.reservationList(request, response);
			
			nextPage = ViewResolver.viewResolverForJSP("reservation_list");
			
			break;
			
		case ReservationConfig.RESERVATION_MODIFY_FORM:
			// 예약 수정 양식
			System.out.println(CLASS_NAME.concat(ReservationConfig.RESERVATION_MODIFY_FORM));
			
			reservationService = new ReservationService();
			reservationService.reservationModifyForm(request, response);
			
			nextPage = ViewResolver.viewResolverForJSP("reservation_modify_form");
			
			break;
			
		case ReservationConfig.RESERVATION_MODIFY_CONFIRM:
			// 예약 수정 확인
			System.out.println(CLASS_NAME.concat(ReservationConfig.RESERVATION_MODIFY_CONFIRM));
			
			reservationService = new ReservationService();
			int resultForModify = reservationService.reservationModifyConfirm(request, response);
			
			switch (resultForModify) {
			case ReservationService.RESERVATION_MODIFY_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("reservation_modify_ok");
				break;

			case ReservationService.RESERVATION_MODIFY_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("reservation_modify_ng");
				
				break;
			}
			
			break;
			
		case ReservationConfig.RESERVATION_CANCEL_CONFIRM:
			// 예약 취소
			System.out.println(CLASS_NAME.concat(ReservationConfig.RESERVATION_CANCEL_CONFIRM));
			
			reservationService = new ReservationService();
			int resultForCancel = reservationService.reservationCancelConfirm(request, response);
			
			switch (resultForCancel) {
			case ReservationService.RESERVATION_CANCEL_SUCCESS:
				nextPage = ViewResolver.viewResolverForJSP("reservation_cancel_ok");
				break;

			case ReservationService.RESERVATION_CANCEL_FAIL:
				nextPage = ViewResolver.viewResolverForJSP("reservation_cancel_ng");
				
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

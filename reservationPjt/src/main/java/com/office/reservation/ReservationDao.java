package com.office.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.office.db.DbInfoForMariadb;

public class ReservationDao implements DbInfoForMariadb {

	final private String CLASS_NAME = "[ReservationDao] ";

	public int insertReservation(ReservationDto reservationDto) {
		System.out.println(CLASS_NAME.concat("insertReservation()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			
			// 3. 작업 명세서(SQL)
			String sql =  "INSERT INTO reservation("
						+ 	"uID, "
						+ 	"rName, "
						+ 	"rMail, "
						+ 	"rPhone, "
						+ 	"departLocationNo, "
						+ 	"rDepartDateTime, "
						+ 	"arrivalLocationNo, "
						+ 	"rArrivalDateTime, "
						+ 	"rAdultCnt, "
						+ 	"rChildCnt, "
						+ 	"rInfantCnt) "
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, reservationDto.getuID());
			pstmt.setString(2, reservationDto.getrName());
			pstmt.setString(3, reservationDto.getrMail());
			pstmt.setString(4, reservationDto.getrPhone());
			pstmt.setInt(5, reservationDto.getDepartLocationNo());
			pstmt.setString(6, reservationDto.getrDepartDateTime());
			pstmt.setInt(7, reservationDto.getArrivalLocationNo());
			pstmt.setString(8, reservationDto.getrArrivalDateTime());
			pstmt.setInt(9, reservationDto.getrAdultCnt());
			pstmt.setInt(10, reservationDto.getrChildCnt());
			pstmt.setInt(11, reservationDto.getrInfantCnt());
			
			// 6. 작업지시
			result = pstmt.executeUpdate();			// 0 || 1						
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {					
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return result;
		
	}

	public List<ReservationDto> selectReservations(String loginedUserId) {
		System.out.println(CLASS_NAME.concat("selectReservations()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservationDto> reservationDtos = new Vector<ReservationDto>();
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			
			// 3. 작업 명세서(SQL)
			String sql =  "SELECT * FROM reservation AS R "
						+ "JOIN depart_location AS D "
						+ "ON R.departLocationNo = D.departLocationNo "
						+ "JOIN arrival_location AS A "
						+ "ON R.arrivalLocationNo = A.arrivalLocationNo "
						+ "WHERE uID = ? "
						+ "ORDER BY rNo DESC";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, loginedUserId);
			
			// 6. 작업지시
			rs = pstmt.executeQuery();			// 0 || 1						
			
			while (rs.next()) {
				
				ReservationDto reservationDto = new ReservationDto();
				
				reservationDto.setrNo(rs.getInt("rNo"));
				reservationDto.setuID(rs.getString("uID"));
				reservationDto.setrName(rs.getString("rName"));
				reservationDto.setrMail(rs.getString("rMail"));
				reservationDto.setrPhone(rs.getString("rPhone"));
				reservationDto.setDepartLocationNo(rs.getInt("departLocationNo"));
				reservationDto.setrDepartDateTime(rs.getString("rDepartDateTime"));
				reservationDto.setArrivalLocationNo(rs.getInt("arrivalLocationNo"));
				reservationDto.setrArrivalDateTime(rs.getString("rArrivalDateTime"));
				reservationDto.setrAdultCnt(rs.getInt("rAdultCnt"));
				reservationDto.setrChildCnt(rs.getInt("rChildCnt"));
				reservationDto.setrInfantCnt(rs.getInt("rInfantCnt"));
				reservationDto.setrRegDate(rs.getString("rRegDate"));
				reservationDto.setrModDate(rs.getString("rModDate"));
				reservationDto.setDepartLocationName(rs.getString("departLocationName"));
				reservationDto.setArrivalLocationName(rs.getString("arrivalLocationName"));
				
				reservationDtos.add(reservationDto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {					
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return reservationDtos;
		
	}

	public ReservationDto selectReservationByRNo(int rNo) {
		System.out.println(CLASS_NAME.concat("selectReservationByRNo()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservationDto> reservationDtos = new Vector<ReservationDto>();
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			
			// 3. 작업 명세서(SQL)
			String sql =  "SELECT * FROM reservation "
						+ "WHERE rNo = ? ";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setInt(1, rNo);
			
			// 6. 작업지시
			rs = pstmt.executeQuery();			// 0 || 1						
			
			while (rs.next()) {
				
				ReservationDto reservationDto = new ReservationDto();
				
				reservationDto.setrNo(rs.getInt("rNo"));
				reservationDto.setuID(rs.getString("uID"));
				reservationDto.setrName(rs.getString("rName"));
				reservationDto.setrMail(rs.getString("rMail"));
				reservationDto.setrPhone(rs.getString("rPhone"));
				reservationDto.setDepartLocationNo(rs.getInt("departLocationNo"));
				reservationDto.setrDepartDateTime(rs.getString("rDepartDateTime"));
				reservationDto.setArrivalLocationNo(rs.getInt("arrivalLocationNo"));
				reservationDto.setrArrivalDateTime(rs.getString("rArrivalDateTime"));
				reservationDto.setrAdultCnt(rs.getInt("rAdultCnt"));
				reservationDto.setrChildCnt(rs.getInt("rChildCnt"));
				reservationDto.setrInfantCnt(rs.getInt("rInfantCnt"));
				reservationDto.setrRegDate(rs.getString("rRegDate"));
				reservationDto.setrModDate(rs.getString("rModDate"));
				
				reservationDtos.add(reservationDto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {					
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return reservationDtos.size() > 0 ? reservationDtos.get(0) : null;
		
	}

	public int updateReservation(ReservationDto reservationDto) {
		System.out.println(CLASS_NAME.concat("updateReservation()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			
			// 3. 작업 명세서(SQL)
			String sql =  "UPDATE "
						+ 	"RESERVATION "
						+ "SET "
						+ 	"rName 						= ?, "
						+ 	"rMail 						= ?, "
						+ 	"rPhone 					= ?, "
						+ 	"departLocationNo 			= ?, "
						+ 	"rDepartDateTime 			= ?, "
						+ 	"arrivalLocationNo 			= ?, "
						+ 	"rArrivalDateTime 			= ?, "
						+ 	"rAdultCnt 					= ?, "
						+ 	"rChildCnt 					= ?, "
						+ 	"rInfantCnt 				= ?, "
						+ 	"rModDate = CURRENT_TIMESTAMP "
						+ "WHERE "
						+ 	"rNo 						= ?";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, reservationDto.getrName());
			pstmt.setString(2, reservationDto.getrMail());
			pstmt.setString(3, reservationDto.getrPhone());
			pstmt.setInt(4, reservationDto.getDepartLocationNo());
			pstmt.setString(5, reservationDto.getrDepartDateTime());
			pstmt.setInt(6, reservationDto.getArrivalLocationNo());
			pstmt.setString(7, reservationDto.getrArrivalDateTime());
			pstmt.setInt(8, reservationDto.getrAdultCnt());
			pstmt.setInt(9, reservationDto.getrChildCnt());
			pstmt.setInt(10, reservationDto.getrInfantCnt());
			pstmt.setInt(11, reservationDto.getrNo());
			
			// 6. 작업지시
			result = pstmt.executeUpdate();					
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {					
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return result;
	}

	public int deleteByRNo(int rNo) {
		System.out.println(CLASS_NAME.concat("deleteByRNo()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			pstmt = conn.prepareStatement("DELETE FROM reservation WHERE rNo = ?");							
			pstmt.setInt(1, rNo);
			result = pstmt.executeUpdate();					
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {					
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return result;
	}
	
}

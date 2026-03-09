package com.office.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.office.db.DbInfoForMariadb;

public class UserDao implements DbInfoForMariadb {

	final private String CLASS_NAME = "[UserDao] ";
	
	public boolean selectUserByUID(String uID) {				// gildong
		System.out.println(CLASS_NAME.concat("selectUserByUID()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);	
			
			// 3. 작업 명세서(SQL)
			String sql = "SELECT COUNT(*) AS CNT FROM USER WHERE uID = ?";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, uID);
			
			// 6. 작업지시
			rs = pstmt.executeQuery();									
			
			while (rs.next()) {
				resultCnt = rs.getInt("CNT");
				
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
		
		return resultCnt > 0 ? true : false;
		
	}

	public int insertUser(UserDto userDto) {
		System.out.println(CLASS_NAME.concat("insertUser()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			
			// 3. 작업 명세서(SQL)
			String sql = "INSERT INTO USER(uID, uPW, uGender, uMail, uPhone) VALUES(?, ?, ?, ?, ?)";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, userDto.getuID());
			pstmt.setString(2, userDto.getuPW());
			pstmt.setString(3, userDto.getuGender());
			pstmt.setString(4, userDto.getuMail());
			pstmt.setString(5, userDto.getuPhone());
			
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

	public UserDto selectUserByIdAndPw(UserDto userDto) {
		System.out.println(CLASS_NAME.concat("selectUserByIdAndPw()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);	
			
			// 3. 작업 명세서(SQL)
			String sql =  "SELECT "
						+ 	"* "
						+ "FROM "
						+ 	"user "
						+ "WHERE "
						+ 	"uID = ? AND uPW = ?";
					
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, userDto.getuID());
			pstmt.setString(2, userDto.getuPW());
			
			// 6. 작업지시
			rs = pstmt.executeQuery();									
			
			while (rs.next()) {
				int uNo = rs.getInt("uNo");
				String uID = rs.getString("uID");
				String uPW = rs.getString("uPW");
				String uGender = rs.getString("uGender");
				String uMail = rs.getString("uMail");
				String uPhone = rs.getString("uPhone");
				String uRegDate = rs.getString("u_reg_Date");
				String uModDate = rs.getString("u_mod_Date");
				
				UserDto dto = new UserDto(uNo, uID, uPW, uGender, uMail, uPhone, uRegDate, uModDate);
				userDtos.add(dto);
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
		
		return userDtos.size() > 0 ? userDtos.get(0) : null;
		
	}

	public UserDto selectUserByUIDForModify(String loginedUserId) {
		System.out.println(CLASS_NAME.concat("selectUserByUIDForModify()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);	
			
			// 3. 작업 명세서(SQL)
			String sql =  "SELECT * FROM user WHERE uID = ?";
					
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, loginedUserId);
			
			// 6. 작업지시
			rs = pstmt.executeQuery();									
			
			while (rs.next()) {
				int uNo = rs.getInt("uNo");
				String uID = rs.getString("uID");
				String uPW = rs.getString("uPW");
				String uGender = rs.getString("uGender");
				String uMail = rs.getString("uMail");
				String uPhone = rs.getString("uPhone");
				String uRegDate = rs.getString("u_reg_Date");
				String uModDate = rs.getString("u_mod_Date");
				
				UserDto dto = new UserDto(uNo, uID, uPW, uGender, uMail, uPhone, uRegDate, uModDate);
				userDtos.add(dto);
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
		
		return userDtos.size() > 0 ? userDtos.get(0) : null;
		
	}

	public int updateUser(UserDto userDto) {
		System.out.println(CLASS_NAME.concat("updateUser()"));
		
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
						+ 	"user "
						+ "SET "
						+ 	"uPw = ?, "
						+ 	"uGender = ?, "
						+ 	"uMail = ?, "
						+ 	"uPhone = ?, "
						+ 	"u_mod_date = CURRENT_TIMESTAMP "
						+ "WHERE "
						+ 	"uNo = ?";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, userDto.getuPW());
			pstmt.setString(2, userDto.getuGender());
			pstmt.setString(3, userDto.getuMail());
			pstmt.setString(4, userDto.getuPhone());
			pstmt.setInt(5, userDto.getuNo());
			
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

	public int deleteByUId(String loginedUserId) {
		System.out.println(CLASS_NAME.concat("deleteByUId()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. java 웹응용프로그램 <-> DB 연결(Connection) + 인증 => 다리 연결
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			
			// 3. 작업 명세서(SQL)
			String sql =  "DELETE FROM user WHERE uID = ?";
			
			// 4. 일꾼 선택(PreparedStatement 생성)
			pstmt = conn.prepareStatement(sql);							
			
			// 5. 일꾼 데이터 주입
			pstmt.setString(1, loginedUserId);
			
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

}

package com.office.user;

public class UserDto {

	private int uNo;
	private String uID;
	private String uPW;
	private String uGender;
	private String uMail;
	private String uPhone;
	private String uRegDate;
	private String uModDate;
	
	public UserDto() { }
	
	public UserDto(String uID, String uPW, String uGender, String uMail, String uPhone) {
		this.uID = uID;
		this.uPW = uPW;
		this.uGender = uGender;
		this.uMail = uMail;
		this.uPhone = uPhone;
	}
	
	public UserDto(String uID, String uPW) {
		this.uID = uID;
		this.uPW = uPW;
	}
	
	public UserDto(int uNo, String uID, String uPW, String uGender, String uMail, String uPhone, String uRegDate,
			String uModDate) {
		super();
		this.uNo = uNo;
		this.uID = uID;
		this.uPW = uPW;
		this.uGender = uGender;
		this.uMail = uMail;
		this.uPhone = uPhone;
		this.uRegDate = uRegDate;
		this.uModDate = uModDate;
	}
	
	public UserDto(int uNo, String uPW, String uGender, String uMail, String uPhone) {
		this.uNo = uNo;
		this.uPW = uPW;
		this.uGender = uGender;
		this.uMail = uMail;
		this.uPhone = uPhone;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getuPW() {
		return uPW;
	}

	public void setuPW(String uPW) {
		this.uPW = uPW;
	}

	public String getuGender() {
		return uGender;
	}

	public void setuGender(String uGender) {
		this.uGender = uGender;
	}

	public String getuMail() {
		return uMail;
	}

	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuRegDate() {
		return uRegDate;
	}

	public void setuRegDate(String uRegDate) {
		this.uRegDate = uRegDate;
	}

	public String getuModDate() {
		return uModDate;
	}

	public void setuModDate(String uModDate) {
		this.uModDate = uModDate;
	}
	
}

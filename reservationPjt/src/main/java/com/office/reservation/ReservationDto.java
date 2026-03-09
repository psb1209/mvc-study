package com.office.reservation;

public class ReservationDto {

	private int rNo;
	private String uID;
	private String rName;
	private String rMail;
	private String rPhone;
	private int departLocationNo;
	private String rDepartDateTime;
	private int arrivalLocationNo;
	private String rArrivalDateTime;
	private int rAdultCnt;
	private int rChildCnt;
	private int rInfantCnt;
	private String rRegDate;
	private String rModDate;
	
	private String departLocationName;
	private String arrivalLocationName;
	
	public ReservationDto() {}
	
	public ReservationDto(int rNo, String uID, String rName, String rMail, String rPhone, int departLocationNo,
			String rDepartDateTime, int arrivalLocationNo, String rArrivalDateTime, int rAdultCnt, int rChildCnt,
			int rInfantCnt, String rRegDate, String rModDate, String departLocationName, String arrivalLocationName) {
		this.rNo = rNo;
		this.uID = uID;
		this.rName = rName;
		this.rMail = rMail;
		this.rPhone = rPhone;
		this.departLocationNo = departLocationNo;
		this.rDepartDateTime = rDepartDateTime;
		this.arrivalLocationNo = arrivalLocationNo;
		this.rArrivalDateTime = rArrivalDateTime;
		this.rAdultCnt = rAdultCnt;
		this.rChildCnt = rChildCnt;
		this.rInfantCnt = rInfantCnt;
		this.rRegDate = rRegDate;
		this.rModDate = rModDate;
		this.departLocationName = departLocationName;
		this.arrivalLocationName = arrivalLocationName;
	}

	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrMail() {
		return rMail;
	}
	public void setrMail(String rMail) {
		this.rMail = rMail;
	}
	public String getrPhone() {
		return rPhone;
	}
	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}
	public int getDepartLocationNo() {
		return departLocationNo;
	}
	public void setDepartLocationNo(int departLocationNo) {
		this.departLocationNo = departLocationNo;
	}
	public String getrDepartDateTime() {
		return rDepartDateTime;
	}
	public void setrDepartDateTime(String rDepartDateTime) {
		this.rDepartDateTime = rDepartDateTime;
	}
	public int getArrivalLocationNo() {
		return arrivalLocationNo;
	}
	public void setArrivalLocationNo(int arrivalLocationNo) {
		this.arrivalLocationNo = arrivalLocationNo;
	}
	public String getrArrivalDateTime() {
		return rArrivalDateTime;
	}
	public void setrArrivalDateTime(String rArrivalDateTime) {
		this.rArrivalDateTime = rArrivalDateTime;
	}
	public int getrAdultCnt() {
		return rAdultCnt;
	}
	public void setrAdultCnt(int rAdultCnt) {
		this.rAdultCnt = rAdultCnt;
	}
	public int getrChildCnt() {
		return rChildCnt;
	}
	public void setrChildCnt(int rChildCnt) {
		this.rChildCnt = rChildCnt;
	}
	public int getrInfantCnt() {
		return rInfantCnt;
	}
	public void setrInfantCnt(int rInfantCnt) {
		this.rInfantCnt = rInfantCnt;
	}
	public String getrRegDate() {
		return rRegDate;
	}
	public void setrRegDate(String rRegDate) {
		this.rRegDate = rRegDate;
	}
	public String getrModDate() {
		return rModDate;
	}
	public void setrModDate(String rModDate) {
		this.rModDate = rModDate;
	}
	public String getDepartLocationName() {
		return departLocationName;
	}
	public void setDepartLocationName(String departLocationName) {
		this.departLocationName = departLocationName;
	}
	public String getArrivalLocationName() {
		return arrivalLocationName;
	}
	public void setArrivalLocationName(String arrivalLocationName) {
		this.arrivalLocationName = arrivalLocationName;
	}
	
}

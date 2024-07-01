package com.profileservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Profile")
public class Profile {
	
    @Id
	private String memberId;
	
	private String fullName;
	private String emailId;
	private String phoneNo;
	private String gender;
	private String role;
	private String password;
	private String address;
	
	
	public Profile() {
		super();
	}
	public Profile(String memberId, String fullName, String emailId, String phoneNo, String gender, String role,
			String password,String address) {
		super();
		this.memberId = memberId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.role = role;
		this.password = password;
		this.address=address;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId =memberId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Profile [memberId=" + memberId + ", fullName=" + fullName + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + ", gender=" + gender + ", role=" + role + ", password=" + password + ", address=" + address
				+ "]";
	}
	
	
	

}

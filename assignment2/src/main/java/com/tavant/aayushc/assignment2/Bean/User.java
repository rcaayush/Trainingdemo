package com.tavant.aayushc.assignment2.Bean;

public class User {



	private String userName;
	
	private Integer userId;
	
	private String tourPack;
	
	public User() {
		
	}

	public User(String userName, Integer userId,String tourPack) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.tourPack=tourPack;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTourPack() {
		return tourPack;
	}

	public void setTourPack(String tourPack) {
		this.tourPack = tourPack;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", tourPack=" + tourPack + "]";
	}
}
	
	
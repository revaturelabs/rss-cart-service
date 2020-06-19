package com.revature.cart.model;

public class Account {
	private int accId;
    private int userId;
    private int accTypeId;
	private int points;

	public Account() {
		super();
	}
	
	public Account(int accId, int userId, int accTypeId, int points) {
		super();
		this.accId = accId;
		this.userId = userId;
		this.accTypeId = accTypeId;
		this.points = points;
	}
	
	public Account(int userId, int accTypeId, int points) {
		super();
		this.userId = userId;
		this.accTypeId = accTypeId;
		this.points = points;
	}
	
	public Account(int userId, int accTypeId) {
		super();
		this.userId = userId;
		this.accTypeId = accTypeId;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", userId=" + userId + ", accTypeId=" + accTypeId + ", points=" + points
				+ "]";
	}
}

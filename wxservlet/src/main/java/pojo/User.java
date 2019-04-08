package pojo;

public class User {
	private String userId;
	private double cash;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getCash() {
		return cash;
	}
	public void setCash(Double cash) {
		this.cash = cash;
	}
	public User() {
		super();		
	}
	public User(String userId) {
		super();
		this.userId = userId;	
		this.cash = 0;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", money=" + cash + "]";
	}	
	
}

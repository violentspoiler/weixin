package pojo;

public class Master {
	private String masterId;
	private String name;
	public Master(String masterId, String name) {
		super();
		this.masterId = masterId;
		this.name = name;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Master() {
		super();		
	}
	
}

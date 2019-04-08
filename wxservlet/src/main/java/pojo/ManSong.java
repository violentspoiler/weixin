package pojo;

public class ManSong {
	int msId;
	Master master;
	double man;
	double song;
	public int getMsId() {
		return msId;
	}
	public void setMsId(int msId) {
		this.msId = msId;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public double getMan() {
		return man;
	}
	public void setMan(double man) {
		this.man = man;
	}
	public double getSong() {
		return song;
	}
	public void setSong(double song) {
		this.song = song;
	}
	public ManSong(int msId, Master master, double man, double song) {
		super();
		this.msId = msId;
		this.master = master;
		this.man = man;
		this.song = song;
	}
	public ManSong() {
		super();
	}
	
}

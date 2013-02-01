package com.abc.kids;

public class Report {

	private long id;
	private long iduser;
	private int Type;
	private int Score;
	private String username;
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long id) {
		this.iduser = id;
	}
	
	public void setUsername(String uname) {
		this.username = uname;
	}
	
	public String getUsername() {
		return username;
	}
		public int getType() {
		return Type;
	}
	public void setType(int type) {
		this.Type = type;
	}
 
	

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		this.Score = score;
	}
	
	 
	
	public String toString() {
		return getUsername()+" "+getScore();
	}

}

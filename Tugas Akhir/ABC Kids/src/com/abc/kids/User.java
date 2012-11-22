package com.abc.kids;

public class User {
	private long id;
	private String Name = "";
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getName() {
		return Name;
	}
 

	public String toString() {
		return getName()    ;
	}

}

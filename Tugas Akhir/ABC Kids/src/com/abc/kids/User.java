package com.abc.kids;

public class User {
	
	private String Name = "";
	private String Age = "";
	 

	public void setName(String name) {
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getAge() {
		return Age;
	}

	 

	public String toString() {
		return "Name: " + getName()  + "; Age: " + getAge()  ;
	}

}

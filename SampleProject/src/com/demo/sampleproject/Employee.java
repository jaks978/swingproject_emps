package com.demo.sampleproject;

public class Employee {

	/**
	 * 
	 */
	String name,adress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Employee [adress=" + adress + ", name=" + name + "]";
	}
}

package com.demo.sampleproject;

import java.util.HashMap;
import java.util.Map;

public class EmployeeClass {

	public static final Map<String,Employee> EMP_DATA = new HashMap<>();
	
	//methods for CRUD Operations
	
	public static boolean checkEmpDetails(String empid)
	{
		boolean aBoolean = EMP_DATA.get(empid)!=null ?true:false;
		return aBoolean;
	}
	
	public static void addEmpDetails(String empid,String empname,String empaddress)
	{
		Employee employee = new Employee();
		employee.setName(empname);
		employee.setAdress(empaddress);
		 EMP_DATA.put(empid, employee);
	}
	
	public static void deleteEmpDetails(String empid)
	{
		EMP_DATA.remove(empid);
		
	}
	
	public static Employee getEmpDetails(String empid)
	{
		boolean aBoolean = EMP_DATA.get(empid)!=null ?true:false;
		Employee employee = null;
		if(aBoolean)
		{
			employee = EMP_DATA.get(empid);
		}
		return employee;
	}
	
}

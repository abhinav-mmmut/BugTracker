package com.Abhinav.AddBugDetails;

public class Bug {
private String bugname;
private String bugdetails;
private String employee;
 
public Bug(){
	
}
public Bug(String bn,String bd,String emp){
	
	bugname=bn;
	bugdetails=bd;
	employee=emp;
}

public String getBugname() {
	return bugname;
}

public void setBugname(String bugname) {
	this.bugname = bugname;
}

public String getBugdetails() {
	return bugdetails;
}

public void setBugdetails(String bugdetails) {
	this.bugdetails = bugdetails;
}

public String getEmployee() {
	return employee;
}

public void setEmployee(String employee) {
	this.employee = employee;
}

@Override
public String toString() {
	return "bugname=" + bugname + ", bugdetails=" + bugdetails + ", employee=" + employee +". ";
}


}

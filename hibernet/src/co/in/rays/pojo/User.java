package co.in.rays.pojo;

public class User {
private int Id;
private String Fname ;
private String Lname;
private String loginId;
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
private String password;

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}

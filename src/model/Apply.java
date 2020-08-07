package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPLICATION")

public class Apply {
	
	@Id
	@Column(name="FIRSTNAME")
   private String firstname;
	@Column(name="LASTNAME")
   private String lastname;
	@Column(name="COURSE")
   private String course;
	@Column(name="EMAIL")
   private String email;
	@Column(name="PHNUMBER")
   private long phnumber;
	@Column(name="AGE")
   private int age;
	@Column(name="GENDER")
   private String gender ;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhnumber() {
	return phnumber;
}
public void setPhnumber(long phnumber) {
	this.phnumber = phnumber;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
   
}

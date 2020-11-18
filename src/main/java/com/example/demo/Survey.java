package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "SURVEYS")
public class Survey {

	@Id
	private String sid;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zip")
	private String zip;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "date")
	private String date;
	
	@Column(name = "likes")
	private String likes;

	@Column(name = "interest")
	private String interested;

	@Column(name = "rating")
	private String rating;

	public Survey() {}

	public Survey(String id, String fname, String lname,
			String address, String city, String state,
			String zip, String phone, String email, String date,
			String likes, String interested, String rating) {
		this.sid = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.likes = likes;
		this.interested = interested;
		this.rating = rating;
	}

	public String getSid() {return sid;}
	public void setSid(String s) {this.sid = s;}
	
	public String getFName() {return(fname);}
	public void setFName(String n) {this.fname = n;}
	
	public String getLName() {return(lname);}
	public void setLName(String n) {this.lname = n;}

	public String getAddress() {return(address);}
	public void setAddress(String a) {this.address = a;}
	
	public String getCity() {return(city);}
	public void setCity(String c) {this.city = c;}
	
	public String getState() {return state;}
	public void setState(String s) {this.state = s;}
	
	public String getZip() {return zip;}
	public void setZip(String z) {this.zip = z;}
	
	public String getPhone() {return phone;}
	public void setPhone(String p) {this.phone = p;}
	
	public String getEmail() {return email;}
	public void setEmail(String e) {this.email = e;}
	
	public String getDate() {return date;}
	public void setDate(String d) {this.date = d;}
	
	public String getLikes() {return likes;}
	public void setLikes(String l) {this.likes = l;}
	
	public String getInterested() {return interested;}
	public void setInterested(String i) {this.interested = i;}
	
	public String getRating() {return rating;}
	public void setRating(String r) {this.rating = r;}

	@Override
	public String toString() {
		return "Survey [id=" + sid + ", name=" + fname + " " + lname + ", date=" + date + "]";
	}
}
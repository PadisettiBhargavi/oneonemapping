package com.hibernateoneone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String street;
private String city;
private String code;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
@Override
public String toString() {
	return "Location [id=" + id + ", street=" + street + ", city=" + city + ", code=" + code + ", getId()=" + getId()
			+ ", getStreet()=" + getStreet() + ", getCity()=" + getCity() + ", getCode()=" + getCode() + "]";
}
public Location(int id, String street, String city, String code) {
	super();
	this.id = id;
	this.street = street;
	this.city = city;
	this.code = code;
}
public Location() {
	
}
}

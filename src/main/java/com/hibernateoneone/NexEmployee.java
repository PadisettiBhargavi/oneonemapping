package com.hibernateoneone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;

@Entity
public class NexEmployee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int salary;
	private String name;
	private String dob;
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String updatedNexEmployee) {
		this.name = updatedNexEmployee;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@OneToOne
	private Location location;
	
	@Override
	public String toString() {
		return "NexEmployee [id=" + id + ", salary=" + salary + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", getId()=" + getId() + ", getSalary()=" + getSalary() + ", getName()=" + getName() + ", getDob()="
				+ getDob() + ", getGender()=" + getGender() + "]";
	}
	public NexEmployee(int id, int salary, String name, String dob, String gender) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	 public NexEmployee() {
		 
	 }
	}
	 
	


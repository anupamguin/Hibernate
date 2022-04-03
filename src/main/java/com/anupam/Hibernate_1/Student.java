package com.anupam.Hibernate_1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name="Student_Details")
@Entity
@Table(name = "Student_Details")
public class Student {

	@Id
	private int id;
	private String name;
	private String city;

	private Certificate certificate;

	public Student() {
		super();
	}

	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
}

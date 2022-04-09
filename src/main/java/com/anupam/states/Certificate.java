package com.anupam.states;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable  // by this annotation this class is embed with Student class
//@Entity
//@Table(name="Certi")
public class Certificate {

	private String course;
	private String duration;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Certificate() {
		super();
	}

	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duration=" + duration + "]";
	}

}

package com.anupam.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Answer1")
@Table(name="Answer1")
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerid;
	private String answer;

	@ManyToOne
	private Question q;

	public Answer() {
		super();
	}

	public Answer(int answerid, String answer, Question q) {
		super();
		this.answerid = answerid;
		this.answer = answer;
		this.q = q;
	}

	@Override
	public String toString() {
		return "Answer [answerid=" + answerid + ", answer=" + answer+"]";
	}

	public Question getQ() {
		return q;
	}

	public void setQ(Question q) {
		this.q = q;
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
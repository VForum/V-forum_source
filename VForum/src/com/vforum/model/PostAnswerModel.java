package com.vforum.model;
/*
 * This is class used to storing data temporarily of posting answers
 */
import java.time.LocalDate;

public class PostAnswerModel {

	private String empUserId;
	private int postId;
	private String answer;
	private int answerId;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;
	public String getEmpUserId() {
		return empUserId;
	}
	public void setEmpUserId(String empUserId) {
		this.empUserId = empUserId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDate getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	@Override
	public String toString() {
		return "PostAnswerModel [empUserId=" + empUserId + ", postId=" + postId + ", answer=" + answer + ", answerId="
				+ answerId + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	
}

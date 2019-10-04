package com.vforum.entities;

import java.time.LocalDate;

public class Answers {
	private String empUserId;
	private int postId;
	private String answer;
	private int answerId;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;
	public Answers() {
		
	}
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
		return "Answers [empUserId=" + empUserId + ", postId=" + postId + ", answer=" + answer + ", answerId="
				+ answerId + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + answerId;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((empUserId == null) ? 0 : empUserId.hashCode());
		result = prime * result + postId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answers other = (Answers) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerId != other.answerId)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (empUserId == null) {
			if (other.empUserId != null)
				return false;
		} else if (!empUserId.equals(other.empUserId))
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}
	
}

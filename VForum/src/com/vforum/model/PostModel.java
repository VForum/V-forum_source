package com.vforum.model;
/*
 * This is class used to storing data temporarily of questions
 */
import java.time.LocalDate;

public class PostModel {
	private String userId;
	private int postId;
	private String post;
	private String category;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		return "PostModel [userId=" + userId + ", postId=" + postId + ", post=" + post + ", category=" + category
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	
}

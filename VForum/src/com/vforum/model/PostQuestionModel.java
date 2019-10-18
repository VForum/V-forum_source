package com.vforum.model;
/*
 * This is class used to storing data temporarily of posts
 */
public class PostQuestionModel {
	private String userId;
	private int postId;
	private String post;
	private String title;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

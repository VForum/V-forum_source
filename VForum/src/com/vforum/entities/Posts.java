package com.vforum.entities;

import java.time.LocalDate;

/**
 * 
 * @author sathish
 *PEMP_UID          NOT NULL VARCHAR2(20)  
POST_ID           NOT NULL NUMBER        
POST                       VARCHAR2(500) 
CATEGORY                   VARCHAR2(100) 
POST_DATE_CREATED          DATE          
POST_DATE_UPDATE           DATE    
 */
public class Posts {

	
	private String userId;
	private int postId;
	private String post;
	private String category;
	private LocalDate dateCreated;
	private LocalDate dateUpdated;
	public Posts() { }
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
		return "Posts [userId=" + userId + ", postId=" + postId + ", post=" + post + ", category=" + category
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + postId;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Posts other = (Posts) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
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
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (postId != other.postId)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	  
}

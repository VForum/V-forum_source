package com.vforum.model;
/*
 * This is class used to storing data temporarily of answers
 */
public class AnswerModel {
	
		private int aPostId;
		private String username;
		private String answer;
		public int getaPostId() {
			return aPostId;
		}
		public void setaPostId(int aPostId) {
			this.aPostId = aPostId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		@Override
		public String toString() {
			return "AnswerModel [aPostId=" + aPostId + ", username=" + username + ", answer=" + answer + "]";
		}
		
}

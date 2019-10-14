package com.vforum.model;

public class AnswerModel {
	
		private int aPostId;
		private String username;
		private String answer;
		public AnswerModel() {
			
		}
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + aPostId;
			result = prime * result + ((answer == null) ? 0 : answer.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
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
			AnswerModel other = (AnswerModel) obj;
			if (aPostId != other.aPostId)
				return false;
			if (answer == null) {
				if (other.answer != null)
					return false;
			} else if (!answer.equals(other.answer))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}
		
}

package com.vforum.service;

import java.util.List;

import com.vforum.model.EmployeeModel;
import com.vforum.model.PostModel;

public interface AdminService {

	public List<EmployeeModel> retrieveEmployees();
	public List<PostModel> retrievePosts();
	public String deleteQuestion(int postId);
}

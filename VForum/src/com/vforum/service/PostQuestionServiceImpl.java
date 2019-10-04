package com.vforum.service;

import java.sql.SQLException;

import com.vforum.dao.PostQuestionDAO;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostQuestionModel;

public class PostQuestionServiceImpl implements PostQuestionService {
	
private PostQuestionDAO postQuestionDAO;
	
	public PostQuestionServiceImpl() {
		this.postQuestionDAO=FactoryEmployeeDB.createQuestionDAO();
		}

	@Override
	public String postQuestion(PostQuestionModel model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Posts posts=new Posts();
		posts.setPost(model.getPost());
		posts.setCategory(model.getTitle());
		posts.setUserId(model.getUserId());

		String result="fail";
		try {
			boolean stored=postQuestionDAO.storeQuestion(posts);
			if(stored)
				result="success";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("!ERROR[Posting of question failed because of internal issues...]");
		}
		return result;
	}

}

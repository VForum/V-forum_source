package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vforum.entities.Posts;
import com.vforum.integrate.ConnectionManager;

public class PostQuestionDAOImpl implements PostQuestionDAO {

	@Override
	public boolean storeQuestion(Posts posts) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("insert into posts(pemp_uid,post_id,post,title) values(?,POSTIDSEQ.nextval,?,?)");
		statement.setString(1,posts.getUserId());
		//System.out.println(posts.getUserId());
		statement.setString(2,posts.getPost());
		//System.out.println(posts.getPost());
		statement.setString(3,posts.getCategory());
		//System.out.println(posts.getCategory());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		
		if(rows>0)
			return true;
		else
	
		return false;
	}

}

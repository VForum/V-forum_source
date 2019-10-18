package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.entities.Posts;
import com.vforum.integrate.ConnectionManager;

public class PostQuestionDAOImpl implements PostQuestionDAO {
	Logger logger=Logger.getLogger(PostQuestionDAOImpl.class.getName());
	@Override
	public boolean storeQuestion(Posts posts) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In PostAnswerDAOImpl storeQuestion method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		logger.info("---- inserting question into database ---- ");
		PreparedStatement statement=
				connection.prepareStatement("insert into questions(p_username,post_id,post,title) values(?,NULL,?,?)");
		statement.setString(1,posts.getUserId());
		statement.setString(2,posts.getPost());
		statement.setString(3,posts.getCategory());
		int rows=statement.executeUpdate();
		statement.close();
		ConnectionManager.closeConnection();
		logger.info("---- In PostAnswerDAOImpl storeQuestion method completed ---- ");
		if(rows>0) {
			return true;}
		else {
	
		return false;}
	}

}

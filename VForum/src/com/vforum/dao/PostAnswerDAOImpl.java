package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.vforum.entities.Answers;
import com.vforum.integrate.ConnectionManager;

public class PostAnswerDAOImpl implements PostAnswerDAO {
	Logger logger=Logger.getLogger(PostAnswerDAOImpl.class.getName());
	@Override
	public boolean storeAnswer(Answers answers) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		logger.info("---- In PostAnswerDAOImpl storeAnswer method started ---- ");
		Connection connection=ConnectionManager.openConnection();
		logger.info("---- inserting answer into database ---- ");
		PreparedStatement statement=
				connection.prepareStatement("insert into answers(a_post_id,a_username,answer) values(?,?,?)");
		statement.setInt(1,answers.getPostId());
		statement.setString(2,answers.getEmpUserId());
		statement.setString(3,answers.getAnswer());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		logger.info("---- In PostAnswerDAOImpl storeAnswer method completed ---- ");
		if(rows>0)
			return true;
		else
	
		return false;
	}

}

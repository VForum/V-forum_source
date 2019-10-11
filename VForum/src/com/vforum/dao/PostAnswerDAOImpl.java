package com.vforum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vforum.entities.Answers;
import com.vforum.integrate.ConnectionManager;

public class PostAnswerDAOImpl implements PostAnswerDAO {

	@Override
	public boolean storeAnswer(Answers answers) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("insert into answers(a_post_id,a_username,answer) values(?,?,?)");
		statement.setInt(1,answers.getPostId());
		statement.setString(2,answers.getEmpUserId());
		statement.setString(3,answers.getAnswer());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		
		if(rows>0)
			return true;
		else
	
		return false;
	}

}

package com.vforum.dao;

import java.sql.SQLException;

import com.vforum.entities.Answers;
import com.vforum.entities.Posts;

public interface PostAnswerDAO {

	public boolean storeAnswer(Answers answers)throws ClassNotFoundException, SQLException;
}

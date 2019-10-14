package com.vforum.dao;
import java.sql.SQLException;
import com.vforum.entities.Posts;

public interface PostQuestionDAO {

	public boolean storeQuestion(Posts posts)throws ClassNotFoundException, SQLException;
}

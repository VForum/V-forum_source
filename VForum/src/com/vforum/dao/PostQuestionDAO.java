package com.vforum.dao;
/*
 * This interface postQuestion contains the function declaration of the storingQuestion
 */
import java.sql.SQLException;
import com.vforum.entities.Posts;

public interface PostQuestionDAO {

	public boolean storeQuestion(Posts posts)throws ClassNotFoundException, SQLException;
}

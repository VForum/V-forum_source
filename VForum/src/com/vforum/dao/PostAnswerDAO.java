package com.vforum.dao;
/*
 * This interface postAnswer contains the function declaration of the storingAnswer
 */
import java.sql.SQLException;

import com.vforum.entities.Answers;

public interface PostAnswerDAO {

	public boolean storeAnswer(Answers answers)throws ClassNotFoundException, SQLException;
}

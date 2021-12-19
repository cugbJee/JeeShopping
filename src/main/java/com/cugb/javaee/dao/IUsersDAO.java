package com.cugb.javaee.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cugb.javaee.bean.Users;

public interface IUsersDAO {

	/***
	 * 
	 * @param users
	 * @return
	 */
	public ArrayList<Users> findUsersBy(Users users);
	/***
	 * findUsers
	 * @return
	 */
	ArrayList findUsers();

	/***
	 * updateUser
	 * @param userid:int
	 * @param pwd:String
	 * @return
	 */
	int updateUser(int userid, String pwd);

	/***
	 * insertUser
	 * @param dt:Timestamp
	 * @return
	 */
	int insertUser(Timestamp dt);

}
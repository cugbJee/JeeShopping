package com.cugb.javaee.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cugb.javaee.bean.Users;

public class UsersDAOMySQLImpl extends baseDAO implements IUsersDAO {

	@Override
	public ArrayList findUsers() {
		String sql = "select userid Userid,username Username,password Pwd from users";
		return findObjs(sql, null,Users.class);
	}

	@Override
	public int updateUser(int userid, String pwd) {
		String sql = "update users set passwod=? where userid=?";
		Object[] params = {userid,pwd};
		return updateObj(sql, params);
	}

	@Override
	public int insertUser(Timestamp dt) {
		String sql = "insert into users(createdate) values(?)";
		Object[] params = {dt};
		return updateObj(sql, params);
	}

	@Override
	public ArrayList<Users> findUsersBy(Users users) {
		String sql = "select userid Userid,username Username,password Pwd from users where username=? and password=?";
		Object[] params  = {users.getUsername(),users.getPwd()};
		return findObjs(sql, params,Users.class);
	}

}

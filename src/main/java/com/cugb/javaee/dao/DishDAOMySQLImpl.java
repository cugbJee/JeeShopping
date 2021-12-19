package com.cugb.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.bean.Dish;
import com.cugb.javaee.bean.Users;
import com.cugb.javaee.utils.JDBCUtils;

public class DishDAOMySQLImpl extends baseDAO implements IDishDAO {

	@Override
	public ArrayList findDishes() {
		String sql = "select * from dish";
		return findObjs(sql,null, Dish.class);
	}

	@Override
	public int updateDish(Dish dish) {
		String sql="update dish set name=?, price=?, description=?,img=? where dishid=?";
		Object []para=new Object[]{dish.getDishname(),dish.getPrice(),dish.getDescrp(),dish.getImag(),dish.getDishid()};
		return updateObj(sql,para);
	}

	/***
	*	String sql="select dishid Dishid,name Dishname,price Price,description Descrip,img Imag" +
	*			"  from dish where dishid = ?";
	*	Object []para=new Object[]{1};
 	*/
	@Override
	public ArrayList findDishesBy(String sql, Object[] params) {
			return findObjs(sql, params,Dish.class);
	}

	@Override
	public int getTotalDishRecords() {
		String sql = "select count(*) from dish;";
		return findRecords(sql);
	}

}

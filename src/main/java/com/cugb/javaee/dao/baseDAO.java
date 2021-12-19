package com.cugb.javaee.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.cugb.javaee.bean.Users;
import com.cugb.javaee.utils.JDBCUtils;

public class baseDAO {

	/***
	 * 寻找记录数
	 * @param sql select count(*) from tablename;
	 * @return
	 */
	public int findRecords(String sql) {
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public ArrayList findObjs(String sql, Object[] params, Class clazz) {
		ArrayList userarray = new ArrayList();
		try {
			Connection conn = JDBCUtils.getConnection();
			// step 3 statement
//				String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			if (params != null) {
				ParameterMetaData psmeta = ps.getParameterMetaData();
				for (int i = 0; i < psmeta.getParameterCount(); i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// step 4 resultset
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString("userid") + "," +rs.getString("username") +
				// ","
				// + rs.getString("password"));
				Object obj = MappingObj(rs, clazz);
				userarray.add(obj);
			}
			// step free
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userarray;
	}

	public int updateObj(String sql, Object[] params) {
		int records = 0;
		try {
			Connection conn = JDBCUtils.getConnection();
			// step 3 statement
//			String sql = "update users set password=? where userid=?";			
			PreparedStatement ps = conn.prepareStatement(sql);
			ParameterMetaData psmeta = ps.getParameterMetaData();
			for (int i = 0; i < psmeta.getParameterCount(); i++) {
				ps.setObject(i + 1, params[i]);
			}
			records = ps.executeUpdate();
			// step free
			JDBCUtils.free(null, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return records;

	}

	private Object MappingObj(ResultSet rs, Class clazz) throws SQLException {

		Object obj;
		try {
			obj = clazz.getDeclaredConstructor().newInstance();
			Method[] methods = clazz.getMethods();
			ResultSetMetaData meta = rs.getMetaData();
			int j = meta.getColumnCount();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				String colname = meta.getColumnLabel(i);
				String methodname = "set" + colname;
				// ѭ������ͬ����������ͨ��������ø÷�������������ֵ
				for (Method method : methods) {
					if (method.getName().equals(methodname)) {
						Object rsobj = rs.getObject(i);
						method.invoke(obj, rsobj);
						break;
					}
				}
			}
			return obj;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		finally {
			return null;
		}
	}

}
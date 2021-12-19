package com.cugb.javaee.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private JDBCUtils() {

    }
    static String Driver;
    static String url;
    static String user;
    static String pwd;
    static DataSource ds;
    //static block
    static {
        // step 1 Class.forname()
        try {
            InputStream in = JDBCUtils.class.getClassLoader().
                    getResourceAsStream("dbconfig.properties");
            Properties prop = new Properties();
            prop.load(in);
//			Driver = prop.getProperty("Driver");
//			url = prop.getProperty("url");
//			user = prop.getProperty("user");
//			pwd = prop.getProperty("pwd");
//			Class.forName(Driver);
            ds = BasicDataSourceFactory.createDataSource(prop);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // step 2 connection
//			conn = DriverManager.getConnection(url, user, pwd);
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void free(ResultSet rs, PreparedStatement ps,Connection conn) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

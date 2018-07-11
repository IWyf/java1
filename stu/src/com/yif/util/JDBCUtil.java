package com.yif.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	public static ComboPooledDataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void release(Connection conn, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	public static void release(Connection conn, Statement st) {
		closeSt(st);
		closeConn(conn);
	}
	
	@SuppressWarnings("unused")
	private static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			rs = null;
		}
	}
	
	private static void closeSt(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			st = null;
		}
	}
	
	private static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			conn = null;
		}
	}
	
}

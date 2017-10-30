package com.guigu.stu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

	// ׼���ĸ������������ݿ�
	// private static String username="guigu";

	// private static String password="guigu";

	// private static String url="jdbc:oracle:thin:@192.168.118.84:1521:ORCL";

	// private static String url="jdbc:oracle:thin:@192.168.118.84:1531:ORCL";

	// private static String jdbcurl="jdbc:oracle:thin:@localhost:1531:ORCL";

	// private static String driver="oracle.jdbc.driver.OracleDriver";

	public static Connection getConnection() {
		// 1.׼���ĸ�����
		// 1)����Properties
		Properties properties = new Properties();
		// 2)��ȡio��
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream(
				"jdbc.properties");

		try {
			properties.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		String jdbcurl = properties.getProperty("jdbc.url");
		String driver = properties.getProperty("jdbc.driver");

		Connection conn = null;
		try {
			// 2.���غ�ע������
			Class.forName(driver);

			// 3.��������
			conn = DriverManager.getConnection(jdbcurl, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ͷ����е�����
	 * 
	 * @param connection
	 * @param statement
	 * @param rs
	 */
	public static void freeAll(Connection connection, Statement statement,
			ResultSet rs) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @param args
	 */
	public static void update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			// ѭ�����еĲ�����Ϣ ���õ�sql�еĲ�����
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.freeAll(conn, ps, null);
		}

	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}

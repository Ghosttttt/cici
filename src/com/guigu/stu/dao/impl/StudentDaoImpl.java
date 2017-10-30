package com.guigu.stu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.guigu.stu.dao.StudentDao;
import com.guigu.stu.model.Student;
import com.guigu.stu.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao {
	QueryRunner queryRunner = new QueryRunner();

	@Override
	public Student login(Student stu) {
		String sql = "select * from student where username=? and password=?";
		Connection conn = null;
		Object[] args = { stu.getUsername(), stu.getPassword() };
		Student findStu = null;
		try {
			conn = JDBCUtils.getConnection();
			findStu = queryRunner.query(conn, sql, new BeanHandler<Student>(Student.class), args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.freeAll(conn, null, null);
		}
		return findStu;
	}

	@Override
	public void add(Student stu) {
		String sql = "insert into student values(?,?,?,?,?,?,?)";
		Connection conn = null;
		Object[] args = { stu.getSid(), stu.getUsername(), stu.getPassword(),
				stu.getSname(), stu.getSage(), stu.getGender(),
				stu.getEducation() };

		try {
			conn = JDBCUtils.getConnection();
			queryRunner.update(conn, sql,args);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.freeAll(conn, null, null);
		}
	}
	
	public static void main(String[] args) {
		StudentDao dao =new StudentDaoImpl();
		Student stu =new Student(2,"zs","zs123","张三",39,"女","博士");
		
		dao.add(stu);
		
	}

}

package com.guigu.stu.dao;

import com.guigu.stu.model.Student;

public interface StudentDao {
	
	public Student login(Student stu);
	
	public void add(Student stu);
}

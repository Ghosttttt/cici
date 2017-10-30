package com.guigu.stu.service.impl;

import com.guigu.stu.dao.StudentDao;
import com.guigu.stu.dao.impl.StudentDaoImpl;
import com.guigu.stu.model.Student;
import com.guigu.stu.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao dao =new StudentDaoImpl();
	
	@Override
	public Student login(Student stu) {
		return dao.login(stu);
	}

	@Override
	public void addNewStudent(Student stu) {
		 dao.add(stu);
		
	}
	
	
	
}

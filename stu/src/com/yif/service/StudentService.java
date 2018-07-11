package com.yif.service;

import java.sql.SQLException;
import java.util.List;

import com.yif.entity.PageBean;
import com.yif.entity.Student;

public interface StudentService {
	public List<Student> findAll() throws SQLException;
	/**
	 * 模糊查询
	 * @param sname
	 * @param sgender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname, String sgender) throws SQLException;
	
	PageBean<Student> findStudentByPage(int currentPage) throws SQLException;

	void insert(Student student) throws Exception;
	
	
	/**
	 * 删除
	 */
	void delete(int sid) throws SQLException;
	
	
	Student findStudentByID(int sid) throws SQLException;
	
	void update(Student student) throws SQLException;

}

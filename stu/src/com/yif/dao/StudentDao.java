package com.yif.dao;

import java.sql.SQLException;
import java.util.List;

import com.yif.entity.Student;

public interface StudentDao {
//	一页显示多少条记录
	int PAGE_SIZE = 5;
	/**
	 * 查询所有学生
	 * @return
	 * @throws SQLException
	 */
	List<Student> findAll() throws SQLException ;
	
	
	/**
	 * 模糊查询
	 * @param sname
	 * @param sgender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname, String sgender) throws SQLException;
	
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
	/**
	 * 加入新的学生
	 */
	void insert(Student student) throws SQLException;
	
	
	/**
	 * 删除
	 */
	void delete(int sid) throws SQLException;
	
	
	/**
	 * 查询单个学生
	 */
	Student findStudentByID(int sid) throws SQLException;
	
	
	void update(Student student) throws SQLException;
	
	int findCount() throws SQLException;
}

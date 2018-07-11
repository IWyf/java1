package com.yif.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.yif.dao.StudentDao;
import com.yif.dao.Impl.StudentDaoImpl;
import com.yif.entity.PageBean;
import com.yif.entity.Student;
import com.yif.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findAll();
	}

	@Override
	public void insert(Student student) throws Exception {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.insert(student);
	}

	@Override
	public void delete(int sid) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.delete(sid);
	}

	@Override
	public Student findStudentByID(int sid) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findStudentByID(sid); 
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.update(student);
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();

		return studentDao.searchStudent(sname, sgender);
	}

	@Override
	public PageBean<Student> findStudentByPage(int currentPage) throws SQLException {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(StudentDao.PAGE_SIZE);
		
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> list = studentDao.findStudentByPage(currentPage);

		pageBean.setList(list);	
		
		int count = studentDao.findCount();
		pageBean.setTotalSize(count);
		int totalPage = count % StudentDao.PAGE_SIZE == 0 ?
						count / StudentDao.PAGE_SIZE : count / StudentDao.PAGE_SIZE + 1;
		pageBean.setTotalPage(totalPage);
		return pageBean;
		
	}
	
}

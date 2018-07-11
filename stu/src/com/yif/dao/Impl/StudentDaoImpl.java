package com.yif.dao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yif.dao.StudentDao;
import com.yif.entity.Student;
import com.yif.util.JDBCUtil;
import com.yif.util.TextUtil;
/**
 * StudentDao的实现类
 */
public class StudentDaoImpl implements StudentDao{

	
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("insert into stu values (null, ?, ?, ?, ?, ?, ?)",
				student.getSname(), student.getGender(), student.getPhone(),
				student.getBirthday(), student.getHobby(), student.getInfo()
				);
		
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from stu where sid = ?", sid);
	}

	@Override
	public Student findStudentByID(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());		
		return runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class), sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());		
	    runner.update("update stu set sname=?, gender=?, phone=?, birthday=?, hobby=?, info=? where sid=?", 
				student.getSname(), student.getGender(), student.getPhone(),
				student.getBirthday(), student.getHobby(), student.getInfo(),
				student.getSid());
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());	
		String sql = "select * from stu where 1=1";
		List<String> list = new ArrayList<String>();
	
		if (!TextUtil.isEmpty(sname)) {
			sql += " and sname like ?";
			list.add("%" + sname + "%");
		}
		if(!TextUtil.isEmpty(sgender)){
			sql += " and gender=?";
			list.add(sgender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {

		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		return 	runner.query("select * from stu limit ? offset ?", 
							  new BeanListHandler<Student>(Student.class), 
							  PAGE_SIZE, 
							 (currentPage - 1) * PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

//		return runner.query("select count(0) from stu", new BeanHandler<Integer>(Integer.class));
		Long res = (Long) runner.query("select count(0) from stu", new ScalarHandler());
		return res.intValue();
	}
	
	


}

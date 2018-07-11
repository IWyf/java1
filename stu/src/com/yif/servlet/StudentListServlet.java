package com.yif.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yif.entity.Student;
import com.yif.service.StudentService;
import com.yif.service.Impl.StudentServiceImpl;

/**
 * 查询学生所有信息，并且呈现到list.jsp页面上
 */
public class StudentListServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			//2、把数据存储到作用域中
			request.setAttribute("list", list);
			//3、跳转到页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

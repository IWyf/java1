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

public class SearchStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("sname");
		String sgender = request.getParameter("sgender");
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> list = service.searchStudent(sname, sgender);
			System.out.println(list.size());
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

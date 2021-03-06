package com.yif.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yif.entity.Student;
import com.yif.service.StudentService;
import com.yif.service.Impl.StudentServiceImpl;

/**
 * 处理学生的添加
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");//1855-3-1
		String[] hobbies = request.getParameterValues("hobby");
		String hobby = Arrays.toString(hobbies);
		hobby = hobby.substring(1, hobby.length() - 1);
		String info = request.getParameter("info");
		
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sname, gender, phone, date, hobby, info);
			StudentService studentService = new StudentServiceImpl();
			studentService.insert(student);
			
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
//			response.sendRedirect("StudentListServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

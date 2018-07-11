package com.yif.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yif.entity.PageBean;
import com.yif.entity.Student;
import com.yif.service.StudentService;
import com.yif.service.Impl.StudentServiceImpl;

/**
 * 分页显示学生列表
 */
public class StudentListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		
		//1、获取页码数
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		try {
			//2、根据指定的页数，获取该页数据
			PageBean<Student> pageBean = service.findStudentByPage(currentPage);
			//3、跳转页面
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

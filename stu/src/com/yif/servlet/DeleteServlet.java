package com.yif.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yif.dao.StudentDao;
import com.yif.dao.Impl.StudentDaoImpl;

/**
 * 用于删除学生
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 int sid = Integer.parseInt(request.getParameter("sid"));
			 StudentDao studentDao = new StudentDaoImpl();
			 studentDao.delete(sid);
			 request.getRequestDispatcher("StudentListServlet").forward(request, response);
		 } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

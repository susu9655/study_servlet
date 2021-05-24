package servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.db.TestDao;

/**
 * Servlet implementation class TesteDeleteServlet
 */
@WebServlet("/info/delete.do")
public class TesteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//num값 읽기
		String num=request.getParameter("num");
		//dao선언
		TestDao dao=new TestDao();
		//삭제 메서드 호출
		dao.deleteTest(num);
		//목록 서블릿으로 이동
		response.sendRedirect("list.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

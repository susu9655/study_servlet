package servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.db.TestDao;
import mysql.db.TestDto;

/**
 * Servlet implementation class TestUpdateFormServlet
 */
@WebServlet("/info/updateform.do")
public class TestUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//num읽기
		String num=request.getParameter("num");
		//dao선언
		TestDao dao=new TestDao();
		//dto얻기
		TestDto dto=dao.getData(num);
		//dto를 request에 저장
		request.setAttribute("dto", dto);
		//updateform.jsp로 포워드
		RequestDispatcher rd=request.getRequestDispatcher("../day0521/updateform.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

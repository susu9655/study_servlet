package servlet.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.db.TestDao;
import mysql.db.TestDto;

/**
 * Servlet implementation class TestListServlet
 */
@WebServlet("/info/list.do")
public class TestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//dao ����
				TestDao dao=new TestDao();
				
				//��� ��������
				List<TestDto> list=dao.getList();
				
				//request �� list �� ����
				request.setAttribute("list", list);
				
				//testlist.jsp �� ������
				RequestDispatcher rd=
						request.getRequestDispatcher("../day0521/testlist.jsp");
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

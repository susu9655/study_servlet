package servlet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.db.TestDao;
import mysql.db.TestDto;

/**
 * Servlet implementation class TestInsertServlet
 */
@WebServlet("/info/insert.do")
public class TestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�ѱ� ���ڵ�
		request.setCharacterEncoding("utf-8");
		//������ �о dto�� �ֱ�
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		String birth =request.getParameter("birth");
		double height =Double.parseDouble(request.getParameter("height"));
		
		TestDto dto=new TestDto();
		dto.setName(name);
		dto.setAge(age);
		dto.setHeight(height);
		dto.setBirth(birth);
		
		//dao����
		TestDao dao=new TestDao();
		dao.insertTest(dto);
		
		//����������� �̵�
		//�����ּҷ� ��� ������ ���ؼ� �����͸� �ٽ� �а� jsp�� ����
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

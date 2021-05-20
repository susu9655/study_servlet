package servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1Servlet
 */
@WebServlet("/bit.do")
public class Ex1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//���� ����
		String name="��ȣ��";
		String addr="���� ������";
		String hp="010-1111-2222";
		
		//request�� ����
		request.setAttribute("name", name);
		request.setAttribute("addr", addr);
		request.setAttribute("hp", hp);
		
		//����� ����ϱ� ���ؼ� jsp���Ϸ� ������
		//������� request�� �״� ���޵ǹǷ� ���� ����Ÿ�� ���޵ȴ�
		//������� url�ּҰ� �ٲ��� �ʴ´�
		RequestDispatcher rd=request.getRequestDispatcher("day0520/ex1result.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

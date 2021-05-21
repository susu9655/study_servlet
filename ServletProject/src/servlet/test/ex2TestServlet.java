package servlet.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex2TestServlet
 */
@WebServlet("/list.do")
public class ex2TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doget���� ���� �ҽ��� ��
		List<TestDto> list=new ArrayList();
		list.add(new TestDto("��ȣ��","����","010-1111-2222"));
		list.add(new TestDto("�̹���","������","010-5555-2342"));
		list.add(new TestDto("������","���ǵ�","010-6666-2222"));
		list.add(new TestDto("������","����","010-0000-1111"));
		list.add(new TestDto("���缮","����","010-1234-1344"));
		
		//requst�� list����
		request.setAttribute("list", list);
		//jsp���Ϸ� ������
		RequestDispatcher rd= request.getRequestDispatcher("day0521/ex2testresult.jsp");
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

package guest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePassFormServlet
 */
@WebServlet("/guest/deletepassform")
public class DeletePassFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���޹��� num �� pageNUm �� ��й�ȣ���� hidden ���� 
		//�����ϹǷ� �о request �� �����Ѵ�
		String num=request.getParameter("num");
		String pageNum=request.getParameter("pageNum");
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		//��������� �̵�
		RequestDispatcher rd=
				request.getRequestDispatcher("deletepassform.jsp");
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

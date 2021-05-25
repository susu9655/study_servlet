package guest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.data.GuestDao;
import guest.data.GuestDto;

/**
 * Servlet implementation class UpdatePassCheckServlet
 */
@WebServlet("/guest/updateform")
public class UpdatePassCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String go="";//�������� ���ϸ� ������ ����
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		String pageNum=request.getParameter("pageNum");
		
		//����� ������ ���������� ������
		//Ʋ���� passfail�� ������
		GuestDao dao=new GuestDao();
		int n=dao.isCheckPass(num, pass);
		if(n==1) {//����� �´� ���
			//num�� �ش��ϴ� dto�� �����´�
			GuestDto dto=dao.getData(num);
			//request�� ����
			request.setAttribute("dto", dto);
			request.setAttribute(pageNum, pageNum);
			go="updateform.jsp";
		}else {
			go="passfail.jsp";
			
		}
		//������
		RequestDispatcher rd=request.getRequestDispatcher(go);
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

package guest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.data.GuestDao;
import guest.data.GuestDto;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/guest/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ڵ�
		request.setCharacterEncoding("utf-8");
		//pageNum�б�
		String pageNum=request.getParameter("pageNum");
	
		//����Ÿ �о dto�� �ֱ�
		GuestDto dto=new GuestDto();
		dto.setAvata(request.getParameter("avata"));
		dto.setContent(request.getParameter("content"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setNum(request.getParameter("num"));
		
		
		//dao����
		GuestDao dao=new GuestDao();
		//���� �޼ҵ� ȣ��
		dao.updateGuest(dto);
		//list�� �̵��ϴµ� ���� �������� �̵�(redirect)
		response.sendRedirect("list?pageNum="+pageNum);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

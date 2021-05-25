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
		//엔코딩
		request.setCharacterEncoding("utf-8");
		//pageNum읽기
		String pageNum=request.getParameter("pageNum");
	
		//데이타 읽어서 dto에 넣기
		GuestDto dto=new GuestDto();
		dto.setAvata(request.getParameter("avata"));
		dto.setContent(request.getParameter("content"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setNum(request.getParameter("num"));
		
		
		//dao선언
		GuestDao dao=new GuestDao();
		//수정 메소드 호출
		dao.updateGuest(dto);
		//list로 이동하는데 보던 페이지로 이동(redirect)
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

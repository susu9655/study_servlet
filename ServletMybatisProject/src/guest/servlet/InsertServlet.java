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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/guest/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//encoding
		request.setCharacterEncoding("utf-8");
		//데이타 읽어서 dto에 넣기
		String avata = request.getParameter("avata");
		String content=request.getParameter("content");
		String pass =request.getParameter("pass");
		String nickname=request.getParameter("nickname");
		
		GuestDto dto=new GuestDto();
		dto.setAvata(avata);
		dto.setContent(content);
		dto.setNickname(nickname);
		dto.setPass(pass);
		
		///dao선언 후 insert메서드 호출
		GuestDao dao=new GuestDao();
		dao.insertGuest(dto);
		//list로 리다이렉트
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
		String go="";//포워드할 파일명 저장할 변수
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		String pageNum=request.getParameter("pageNum");
		
		//비번이 맞으면 수정폼으로 포워드
		//틀리면 passfail로 포워드
		GuestDao dao=new GuestDao();
		int n=dao.isCheckPass(num, pass);
		if(n==1) {//비번이 맞는 경우
			//num에 해당하는 dto를 가져온다
			GuestDto dto=dao.getData(num);
			//request에 저장
			request.setAttribute("dto", dto);
			request.setAttribute(pageNum, pageNum);
			go="updateform.jsp";
		}else {
			go="passfail.jsp";
			
		}
		//포워드
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

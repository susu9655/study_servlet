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
		//변수 선언
		String name="강호동";
		String addr="서울 강남구";
		String hp="010-1111-2222";
		
		//request에 저장
		request.setAttribute("name", name);
		request.setAttribute("addr", addr);
		request.setAttribute("hp", hp);
		
		//결과를 출력하기 위해서 jsp파일로 포워드
		//포워드는 request가 그댈 전달되므로 위의 데이타가 전달된다
		//포워드는 url주소가 바뀌지 않는다
		RequestDispatcher rd=request.getRequestDispatcher("day0520/ex1result.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

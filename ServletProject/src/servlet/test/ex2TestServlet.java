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
		//doget에다 보통 소스를 줌
		List<TestDto> list=new ArrayList();
		list.add(new TestDto("강호동","강남","010-1111-2222"));
		list.add(new TestDto("이미자","영등포","010-5555-2342"));
		list.add(new TestDto("한지혜","여의도","010-6666-2222"));
		list.add(new TestDto("강수지","도곡","010-0000-1111"));
		list.add(new TestDto("유재석","송파","010-1234-1344"));
		
		//requst에 list저장
		request.setAttribute("list", list);
		//jsp파일로 포워드
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

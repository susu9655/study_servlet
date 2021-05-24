package guest.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.data.GuestDao;
import guest.data.GuestDto;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/guest/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//dao선언
		GuestDao dao=new GuestDao();
		//총 개수 구하기
		int totalCount=dao.getTotalCount();
		//request에 저장
		request.setAttribute("totalCount", totalCount);
		
		//페이징에 필요한 코드
		int totalPage;//총 페이지수
		int startPage;//각 블럭의 시작 페이지
		int endPage;//각 블럭의 끝 페이지
		int start;//각 페이지의 시작번호
		int end;//각 페이지의 끝번호
		int no;//각 페이지의 출력을 시작할 번호
		int perPage=3;//한 페이지에 보여질 글의 개수
		int perBlock=5;//한 블럭에 보여질 페이지의 개수
		int currentPage;//현재 페이지
		
		//총페이지수 구하기
		//예:perPage가 5인 경우 총 글개수가 13개면 총 몇페이지여야할까?
		totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);//나머지가 있으면 무조건 1을 더함
		//현재페이지(pageNum이 널인땐 무조건 1페이지로 이동)
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(pageNum);
		}
		//ex1)현재페이지가 3인 경우 start페이지는 1,endpage=5
		//ex2)현재페이지가 6인 경우 start페이지는 6,endpage=10
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		
		//만약 총 페이지수가 8일 경우
		//2번째 블럭은 startPage가 6 endPage가 10이 되는데
		//이때 endPage는 8로 수정해주어야 한다
		if(endPage>totalPage)
			endPage=totalPage;
		
		//각 페이지의 시작번호,끝번호 구하기
		//오라클은 첫글이 1번, mysql은 첫 글이 0번
		//현재페이지가 1일 경우 start는 0, 2일겨우 3..
		start=(currentPage-1)*perPage;
		
		
		//각 글앞에 붙일 시작번호 구하기
		//ex)총 글이 20개인 경우 1페이지는 20부터,2페이지는 15부터
		//출력해서 1씩 감소해가며 출력할 것
		no=totalCount-(currentPage-1)*perPage;
		
		//목록가져오기
		List<GuestDto>list = dao.getList(start, perPage);
		//출력시 필요한 변수들은 모두 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("no", no);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		
		
		
		//list.jsp로 포워드
		RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
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

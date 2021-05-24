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
		//dao����
		GuestDao dao=new GuestDao();
		//�� ���� ���ϱ�
		int totalCount=dao.getTotalCount();
		//request�� ����
		request.setAttribute("totalCount", totalCount);
		
		//����¡�� �ʿ��� �ڵ�
		int totalPage;//�� ��������
		int startPage;//�� ���� ���� ������
		int endPage;//�� ���� �� ������
		int start;//�� �������� ���۹�ȣ
		int end;//�� �������� ����ȣ
		int no;//�� �������� ����� ������ ��ȣ
		int perPage=3;//�� �������� ������ ���� ����
		int perBlock=5;//�� ���� ������ �������� ����
		int currentPage;//���� ������
		
		//���������� ���ϱ�
		//��:perPage�� 5�� ��� �� �۰����� 13���� �� �������������ұ�?
		totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);//�������� ������ ������ 1�� ����
		//����������(pageNum�� ���ζ� ������ 1�������� �̵�)
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			currentPage=1;
		}else{
			currentPage=Integer.parseInt(pageNum);
		}
		//ex1)������������ 3�� ��� start�������� 1,endpage=5
		//ex2)������������ 6�� ��� start�������� 6,endpage=10
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		
		//���� �� ���������� 8�� ���
		//2��° ���� startPage�� 6 endPage�� 10�� �Ǵµ�
		//�̶� endPage�� 8�� �������־�� �Ѵ�
		if(endPage>totalPage)
			endPage=totalPage;
		
		//�� �������� ���۹�ȣ,����ȣ ���ϱ�
		//����Ŭ�� ù���� 1��, mysql�� ù ���� 0��
		//������������ 1�� ��� start�� 0, 2�ϰܿ� 3..
		start=(currentPage-1)*perPage;
		
		
		//�� �۾տ� ���� ���۹�ȣ ���ϱ�
		//ex)�� ���� 20���� ��� 1�������� 20����,2�������� 15����
		//����ؼ� 1�� �����ذ��� ����� ��
		no=totalCount-(currentPage-1)*perPage;
		
		//��ϰ�������
		List<GuestDto>list = dao.getList(start, perPage);
		//��½� �ʿ��� �������� ��� request�� ����
		request.setAttribute("list", list);
		request.setAttribute("no", no);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		
		
		
		//list.jsp�� ������
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

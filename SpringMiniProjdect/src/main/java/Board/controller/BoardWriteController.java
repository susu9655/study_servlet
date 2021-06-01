package Board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.BoardDao;
import spring.dto.BoardDto;
import upload.util.SpringFileWriter;

@Controller
public class BoardWriteController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/form")
	public ModelAndView form(
			@RequestParam(defaultValue = "1") String pageNum,
			@RequestParam(defaultValue = "0") int reg,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "0") int num,
			HttpSession session
			) {
		ModelAndView mview =new ModelAndView();
		//���ǿ� ����� ���̵�
		String id=(String)session.getAttribute("myid");
		//���̵� �ش��ϴ� �̸�
		String name=dao.searchName(id);
		//����� ���� ���� [���]�� ������ �̷��� �ۼ�
		String subject="";
		if(num!=0) {
			subject="[���]"+dao.getData(num).getSubject();
		}
		
		mview.addObject("name",name);
		mview.addObject("subject",subject);
		mview.addObject("pageNum",pageNum);
		mview.addObject("reg",reg);
		mview.addObject("restep",restep);
		mview.addObject("relevel",relevel);
		mview.addObject("num",num);
		mview.setViewName("/board/writeform");
		return mview;
	}
	
	@PostMapping("/board/insert")
	public String insert(
			@ModelAttribute BoardDto dto,
			@RequestParam String pageNum,
			HttpServletRequest request
			) {
		//�̹����� ���ε�� ���� ���ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//�̹��� ���ε� ������ ��� no��� ����
		String upload="";
		String f=dto.getPhoto().get(0).getOriginalFilename();
		if(f.equals(""))
			upload="no";
		else {
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getPhoto()) {
				//������ �̹��� �����ϱ�(����� �̹����� ��ȯ)
				String fileName=sfw.writeFile(file, path);
				upload+=fileName+",";
			}
			//������ �ĸ� ����
			upload=upload.substring(0,upload.length()-1);
		}
		
		//dto�� ���ε� ���ϸ� ����
		dto.setUploadname(upload);
		//db��insert
		dao.insertBoard(dto);
		
		return "redirect:list?pageNum="+pageNum;
	}
}

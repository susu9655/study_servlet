package Board.controller;

import javax.servlet.http.HttpServletRequest;

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
public class BoardUpdateController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/updateform")
	public ModelAndView updateForm(@RequestParam int num,
			@RequestParam String pageNum)
	{
		ModelAndView mview=new ModelAndView();
		BoardDto dto=dao.getData(num);
		
		mview.addObject("dto",dto);
		mview.addObject("pageNum",pageNum);
		mview.setViewName("/board/updateform");
		return mview;
	}
	

@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam String pageNum,
			HttpServletRequest request) {
		//�̹����� ���ε�� ���� ���ϱ�
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);

		//�̹��� ���ε� ������ ��� no ��� ����
		String upload = "";
		String f = dto.getPhoto().get(0).getOriginalFilename();
		if (f.equals(""))
			upload = null;
		else {//���ε� �������
			SpringFileWriter sfw = new SpringFileWriter();
			for (MultipartFile file : dto.getPhoto()) {
				//������ �̹��� �����ϱ�(����� �̹������ȯ)
				String fileName = sfw.writeFile(file, path);
				upload += fileName + ",";
			}
			//������ �ĸ� ����
			upload = upload.substring(0, upload.length() - 1);
		}

		//dto �� ���ε����ϸ� ����
		dto.setUploadname(upload);
		//db �� insert
		dao.updateBoard(dto);

		return "redirect:content?num="+dto.getNum()+"&pageNum="+pageNum;
	}
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam String pageNum, @RequestParam String num) {
		
		dao.deleteBoard(num);
		
		return "redirect:list?pageNum="+pageNum;
	}

}

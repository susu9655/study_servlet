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
		//이미지가 업로드될 폴더 구하기
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);

		//이미지 업로드 안했을 경우 no 라고 저장
		String upload = "";
		String f = dto.getPhoto().get(0).getOriginalFilename();
		if (f.equals(""))
			upload = null;
		else {//업로드 했을경우
			SpringFileWriter sfw = new SpringFileWriter();
			for (MultipartFile file : dto.getPhoto()) {
				//폴더에 이미지 저장하기(저장된 이미지명반환)
				String fileName = sfw.writeFile(file, path);
				upload += fileName + ",";
			}
			//마지막 컴마 제거
			upload = upload.substring(0, upload.length() - 1);
		}

		//dto 에 업로드파일명 저장
		dto.setUploadname(upload);
		//db 에 insert
		dao.updateBoard(dto);

		return "redirect:content?num="+dto.getNum()+"&pageNum="+pageNum;
	}
	
	@GetMapping("/board/delete")
	public String delete(
			@RequestParam int num,
			@RequestParam String pageNum
			)
	{
		//삭제
		dao.deleteBoard(num);
		
		return "redirect:list?pageNum="+pageNum;
	}


}

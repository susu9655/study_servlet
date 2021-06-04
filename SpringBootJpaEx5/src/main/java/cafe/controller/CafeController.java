package cafe.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cafe.data.CafeDao;
import cafe.data.CafeDto;


@Controller
public class CafeController {
	@Autowired
	CafeDao dao;
	
	
	@GetMapping({"/","/list"})
	public ModelAndView list() {
		ModelAndView mview =new ModelAndView();
		mview.addObject("mes","스프링 부트 셋팅하기");
		
		List<CafeDto>list=dao.getAllDatas();
		
		mview.addObject("list",list);
		mview.setViewName("list");
		return mview;
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		
		return "writeform";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute CafeDto dto,
			@RequestParam MultipartFile upload,
			HttpServletRequest request) {
		
		
		String path=request.getSession().getServletContext().getRealPath("/");
		System.out.println(path);
		//파일명 앞에 붙일 날짜 구하기
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName="photo"+sdf.format(new Date())+upload.getOriginalFilename();
		System.out.println(path);
		//dto에 업로드될 파일명 저장
		dto.setImage(fileName);
		
		
		try {
			//업로드
			upload.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//db에 데이타 추가
		dao.insert(dto);
		//목록으로 이동
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public ModelAndView updateform(@RequestParam long num) {
		CafeDto dto=dao.getData(num);
		ModelAndView mview =new ModelAndView();
		mview.addObject("dto",dto);
		mview.setViewName("updateform");
		return mview;
	}
	
	@PostMapping("/update")
	public String update(
			@ModelAttribute CafeDto dto,
			HttpServletRequest request,
			MultipartFile upload
			) {
		//이미지가 업로드될 폴더 구하기
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println(path);
		
		//이미지를 업로드 했을 경우 업로드
		String f = upload.getOriginalFilename();
		if(!f.equals("")) {
			//파일명 앞에 붙일 날짜 구하기
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName="photo"+sdf.format(new Date())+upload.getOriginalFilename();
			System.out.println(path);
			//dto에 업로드될 파일명 저장
			dto.setImage(fileName);
			
			
			try {
				//업로드
				upload.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			CafeDto dto1=dao.getData(dto.getNum());
			dto.setImage(dto1.getImage());
		}
			
		
		dao.update(dto);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam long num) {
		dao.delete(num);
		return "redirect:list";
	}
}

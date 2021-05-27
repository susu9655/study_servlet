package day0527.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import upload.util.SpringFileWriter;

@Controller
public class UploadController {
	@GetMapping("/imageform")
	public String uploadForm() {
		return "day0527/uploadform";
	}
	@GetMapping("/imageform2")
	public String uploadForm2() {
		return "day0527/uploadform2";
	}
	@GetMapping("/imageform3")
	public String uploadForm3() {
		return "day0527/uploadform3";
	}
	
	@PostMapping("/upload")
	public ModelAndView upload(
			@RequestParam String name,
			@RequestParam MultipartFile photo,
			HttpServletRequest request
			) {
		ModelAndView mview =new ModelAndView();
		//저장할 실제경로 구하기(web-inf/image에 업로드되도록 하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//path에 file저장하기
		SpringFileWriter sfw=new SpringFileWriter();
		String filename=sfw.writeFile(photo, path);
		
		mview.addObject("photo",filename);
		mview.addObject("name",name);
		
		mview.setViewName("day0527/uploadresult");
		return mview;
	}
	
	@PostMapping("/upload2")
	public ModelAndView upload2(
			HttpServletRequest request,
			@RequestParam String name,
			@RequestParam ArrayList<MultipartFile>photo
			) {
		ModelAndView mview =new ModelAndView();
		//파일이 여러개이므로 벡터로 만들어서 보냄
		List<String>files=new Vector<String>();//여러개 파일명 저장 변수
		//저장할 실제경로 구하기(web-inf/image에 업로드되도록 하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//path에 file저장하기
		SpringFileWriter sfw=new SpringFileWriter();
		
		mview.addObject("name",name);
		for(MultipartFile file:photo) {
			String filename=sfw.writeFile(file, path);
			files.add(filename);
		}
		mview.addObject("files",files);			
		mview.setViewName("day0527/uploadresult2");
		return mview;
	}
	
	@PostMapping("/upload3")
	public ModelAndView upload3(
			HttpServletRequest request,
			@RequestParam String name,
			@RequestParam ArrayList<MultipartFile>photo
			) {
		ModelAndView mview =new ModelAndView();
		//파일이 여러개이므로 벡터로 만들어서 보냄
		List<String>files=new Vector<String>();//여러개 파일명 저장 변수
		//저장할 실제경로 구하기(web-inf/image에 업로드되도록 하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//path에 file저장하기
		SpringFileWriter sfw=new SpringFileWriter();
		
		mview.addObject("name",name);
		for(MultipartFile file:photo) {
			String filename=sfw.writeFile(file, path);
			files.add(filename);
		}
		mview.addObject("files",files);			
		mview.setViewName("day0527/uploadresult3");
		return mview;
	}
}

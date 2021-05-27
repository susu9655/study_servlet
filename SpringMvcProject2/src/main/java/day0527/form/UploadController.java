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
		//������ ������� ���ϱ�(web-inf/image�� ���ε�ǵ��� �ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//path�� file�����ϱ�
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
		//������ �������̹Ƿ� ���ͷ� ���� ����
		List<String>files=new Vector<String>();//������ ���ϸ� ���� ����
		//������ ������� ���ϱ�(web-inf/image�� ���ε�ǵ��� �ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//path�� file�����ϱ�
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
		//������ �������̹Ƿ� ���ͷ� ���� ����
		List<String>files=new Vector<String>();//������ ���ϸ� ���� ����
		//������ ������� ���ϱ�(web-inf/image�� ���ε�ǵ��� �ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);
		
		//path�� file�����ϱ�
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

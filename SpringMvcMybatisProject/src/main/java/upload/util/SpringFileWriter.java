package upload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class SpringFileWriter {
	FileOutputStream fos;
	
	public String writeFile(MultipartFile file,String path) {
		//������ ���ϸ� ���ϱ� ���� ��� a.jpg
		//file123456_a.jpg���� ����ǵ��� �غ���
		long time=new Date().getTime();//�ð��� �ʸ� ȯ���ؼ� ���ڷ� ��ȯ
		//������ ���ϸ��� 
		String fileName="file"+time+"_"+file.getOriginalFilename();
		
		//path������ �����ϱ�
		try {
			byte []fileData=file.getBytes();
			fos=new FileOutputStream(path+"\\"+fileName);
			fos.write(fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return fileName;//���ε�� ���ϸ��� ��Ʈ�ѷ��� ����
	}
}

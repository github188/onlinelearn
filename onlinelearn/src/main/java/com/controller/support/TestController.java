package com.controller.support;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_UserService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
@Controller
@RequestMapping("/admin/user")
public class TestController {
	@Autowired 
	private Edu_UserService edu_UserService;
	@RequestMapping("/listUser")
	public ModelAndView test1(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request){
		PageHelper.startPage(page, 5);
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Edu_User> list=edu_UserService.listUser(map);
		PageInfo<Edu_User> pageInfo=new PageInfo<Edu_User>(list);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/back/user/index");
		mv.addObject("listUser", list);
		mv.addObject("page", pageInfo);
		return mv;
	}

	@RequestMapping("/excel")
	public String excel(String filename,HttpServletRequest request,HttpServletResponse response){
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Edu_User> list=edu_UserService.listUser(map);
		////////////////////��ArrayList�е�����д�뵽����excel��///////////////////////////          
		//��һ��������һ��workbook��Ӧһ��excel�ļ�  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//�ڶ�������workbook�д���һ��sheet��Ӧexcel�е�sheet  
		HSSFSheet sheet = workbook.createSheet("�û���һ");  
		//����������sheet������ӱ�ͷ��0�У��ϰ汾��poi��sheet������������  
		HSSFRow row = sheet.createRow(0);  
		//���Ĳ���������Ԫ�����ñ�ͷ  
		HSSFCell cell = row.createCell(0);  
		cell.setCellValue("�û�Id");  
		cell = row.createCell(1);  
		cell.setCellValue("�ֻ���");  
		cell=row.createCell(2);  
		cell.setCellValue("�����");  
		cell=row.createCell(3);  
		cell.setCellValue("�û���"); 
		cell=row.createCell(4);  
		cell.setCellValue("�ǳ�"); 
		cell=row.createCell(5);  
		cell.setCellValue("�Ա�"); 
		cell=row.createCell(6);  
		cell.setCellValue("����"); 
		cell=row.createCell(7);  
		cell.setCellValue("״̬"); 
		//���岽��д��ʵ�����ݣ�ʵ��Ӧ������Щ���ݴ����ݿ�õ�,�����װ���ݣ����ϰ����󡣶��������ֵ��Ӧ���ÿ�е�ֵ  
		for (int i = 0; i <list.size(); i++)   
		{  
			HSSFRow row1 = sheet.createRow(i+1);  
			Edu_User user=list.get(i);  
			//������Ԫ����ֵ  
			row1.createCell(0).setCellValue(user.getUser_id());  
			row1.createCell(1).setCellValue(user.getMobile());  
			row1.createCell(2).setCellValue(user.getEmail()); 
			row1.createCell(3).setCellValue(user.getUser_name()); 
			row1.createCell(4).setCellValue(user.getShow_name()); 
			row1.createCell(5).setCellValue(user.getSex()); 
			row1.createCell(6).setCellValue(user.getAge()); 
			row1.createCell(7).setCellValue(user.getIs_avalible()); 
			
		}  
		//���ļ����浽ָ����λ��  
		try   
		{  
			FileOutputStream fos = new FileOutputStream(filename);  
			workbook.write(fos);  
			System.out.println("��ϲ��������ɹ�������������");  
			fos.close();  
		}   
		catch (IOException e)   
		{  
			System.out.println("д���ļ���������");  
			e.printStackTrace();  
		}  
		return "/admin/user/listUser";

	}



public Map initMap(HttpServletRequest request,Map map){
	String name=request.getParameter("name");
	String type=request.getParameter("type");
	String statr=request.getParameter("start");
	String end=request.getParameter("end");
	if (statr!=null&&statr.length()>0) {
		map.put("start", statr);
	}
	if (end!=null&&end.length()>0) {
		map.put("end", end);
	}

	if (type==null) {
		type="-1";
	}
	map.put("type", Integer.valueOf(type));
	map.put("name", name);
	return map;

}
@RequestMapping("/updatepwd")
@ResponseBody
public int update(@RequestParam int id,@RequestParam String fir) {
	Map map = new HashMap<>();
	System.out.println(id+","+fir);
	map.put("user_id", id);
	map.put("password", fir);
	edu_UserService.update(map);
	return 1;
}


@RequestMapping("/dongjiezz")
@ResponseBody
public int update(@RequestParam int id,@RequestParam int zz) {
	System.out.println(zz);
	Map map = new HashMap<>();
	map.put("user_id", id);
	if (zz == 2) {
		map.put("zz", 1);
	} else {
		map.put("zz", 2);
	}
	edu_UserService.updateZZ(map);
	return 1;
}
@RequestMapping("/down")
public String downAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
	java.io.OutputStream o = response.getOutputStream();
	byte b[] = new byte[500];
	java.io.File fileLoad = new java.io.File(request.getRealPath("/Excel/user.xls"));
	System.out.println(fileLoad.getPath());
	response.reset();
	response.setContentType("application/vnd.ms-excel");
	response.setHeader("content-disposition",
			"attachment; filename=text.xls");
	long fileLength = fileLoad.length();
	String length1 = String.valueOf(fileLength);
	response.setHeader("Content_Length", length1);
	java.io.FileInputStream in = new java.io.FileInputStream(fileLoad);
	int n;
	while ((n = in.read(b)) != -1) {
		o.write(b, 0, n);
	}
	in.close();
	o.close();

	return null;
}


@RequestMapping("/open")
public String open(){
	return "/back/user/parseExcel";	
}

@RequestMapping("/parseExcel")
public String parseExcel(@RequestParam("file")MultipartFile file,Edu_User user)throws Exception{
	//����������  
	InputStream stream =file.getInputStream();  
	//��ȡExcel�ļ�����  
	Workbook  rwb = Workbook.getWorkbook(stream);  
	//��ȡ�ļ���ָ�������� Ĭ�ϵĵ�һ��  
	Sheet sheet = rwb.getSheet(0);    
	//����(��ͷ��Ŀ¼����Ҫ����1��ʼ)  
	for(int i=2; i<sheet.getRows(); i++){  
		//����һ������ �����洢ÿһ�е�ֵ  
		String[] str = new String[sheet.getColumns()];  
		Cell cell = null;  
		//����  
		for(int j=0; j<sheet.getColumns(); j++){  
			//��ȡ��i�У���j�е�ֵ  
			cell = sheet.getCell(j,i);      
			str[j] = cell.getContents();  

			if (j==0) {
				if (str[j].equals("")||str[j]==null) {
					return "redirect:/admin/user/listUser";
				}
				user.setMobile(str[j]);
			}if (j==1) {
				user.setEmail(str[j]);

			}if (j==2) {
				user.setPassword(str[j]);

			}if (j==3) {
				user.setUser_name(str[j]);

			}if (j==4) {
				user.setShow_name(str[j]);

			}if (j==5) {
				if (str[j].equals("��")) {
					user.setSex(0);
				}else {
					user.setSex(1);
				}
			}if (j==6) {
				user.setAge(Integer.valueOf(str[j]));

			}if (j==7) {
				user.setCreate_time(Timestamp.valueOf(str[j]));
			}
		}  
		Date date=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strdate = format.format(date);
		user.setLast_system_time(Timestamp.valueOf(strdate));
		System.out.println(user);
		edu_UserService.save(user);
	}  
	return "redirect:/admin/user/listUser";
}


}
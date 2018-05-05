package com.controller.support;
import java.io.InputStream;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
		System.out.println(pageInfo);
		return mv;
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

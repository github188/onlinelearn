package com.controller.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.EduCourse;
import com.bean.EduCourseKpoint;
import com.bean.EduCourseNote;
import com.bean.Edu_User;
import com.service.ConurseNoseService;
import com.service.CourseCommentService;
import com.service.CourseStudyhistoryService;
import com.service.EduNoseUserService;
import com.service.KpointNoseService;
import com.service.SubjectNoseService;
import com.service.TeacherNoseService;
import com.util.JsonUtils;
import com.util.ObjectUtils;
import com.util.Result;

@Controller
@RequestMapping("/front")
public class CouseNoseController {

	@Autowired
	private ConurseNoseService conurseNoseService;
	@Autowired
	private KpointNoseService kpointNoseService;
	@Autowired
	private SubjectNoseService subjectNoseService;
	@Autowired
	private TeacherNoseService teacherNoseService;
	@Autowired 
	private CourseStudyhistoryService courseStudyhistoryService;
	@Autowired
	private EduNoseUserService eduNoseUserService;
	@Autowired
	private CourseCommentService courseCommentService;
	@RequestMapping("/toCourseslist")
	public String toCourseslist(Model model,EduCourse course){
		model.addAttribute("courseList",conurseNoseService.listbyCourse(course));
		model.addAttribute("teacherList",teacherNoseService.listbyTeacher());
		model.addAttribute("subjectList",subjectNoseService.listbySubject());
		return "web/course/courses-list";
	}
	@RequestMapping("/tocourseinfor")
	public String tocourseinfor(Model model,int courseid){
		model.addAttribute("course",conurseNoseService.byIdcourse(courseid));
		model.addAttribute("teacherList",teacherNoseService.bysubjectTeacher(conurseNoseService.byIdcourse(courseid).getSubject_id()));
		model.addAttribute("parentKpointList",kpointNoseService.listbyKpoint(courseid));
		return "web/course/course-infor";
	}
	@RequestMapping("/tovedioplay")
	public String tovedioplay(Model model,int courseid){
		model.addAttribute("interfixCourse",conurseNoseService.byIdcourse(courseid));
		model.addAttribute("parentKpointList",kpointNoseService.listbyKpoint(courseid));
		model.addAttribute("SomeoneHas",eduNoseUserService.SomeoneHas(courseid));
		model.addAttribute("courseId",courseid);
		model.addAttribute("commentList",courseCommentService.listallCourseComment());
		return "web/course/player-video";
	}
	@RequestMapping("/ajax/getKopintHtml")
	public String getKopintHtml(Model model, HttpServletRequest request,@RequestParam("kpointId")int kpointId, HttpServletResponse response) {
		System.out.println(kpointId+"�ڵ�id");
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			EduCourseKpoint courseKpoint= kpointNoseService.bykopint(kpointId);
			System.out.println(courseKpoint.getVideo_Type());
			// ���������ݲ���ȷʱֱ�ӷ���
			if (ObjectUtils.isNull(courseKpoint)) {
				out.println("<script>var noCover=true; dialog dialog('��ʾ','��������',1);</script>");
				return null;
			}
			
			//��ȡ�γ�
			EduCourse course = conurseNoseService.byIdcourse(courseKpoint.getCourse_Id());
			if (course==null) {
				return "web/course/videocode";
			}
			model.addAttribute("courseKpoint",courseKpoint);
			model.addAttribute("course",course);
				// ��Ƶurl
			String videourl = courseKpoint.getVideo_Url();
			System.out.println("��Ƶurl"+videourl);
				// ��������
			String videotype = courseKpoint.getVideo_Type();
				// ��������
			model.addAttribute("videourl", videourl);
			model.addAttribute("videotype", videotype);
			model.addAttribute("isok", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "web/course/videocode";
	}
	@RequestMapping("/courseNote/ajax/addnote")
	@ResponseBody
	public Result addnode(EduCourseNote courseNote,HttpSession session){
		Result result=new Result();
		Edu_User  user=	(Edu_User) session.getAttribute("login_success");
		courseNote.setUserId(user.getUser_id());
		EduCourseNote querynode = conurseNoseService.querynode(courseNote);
		System.out.println(courseNote.getContent());
		if(querynode!=null){
			if(!"".equals(querynode.getContent())&&querynode.getContent()!=null){
				conurseNoseService.updatenode(courseNote);
				System.out.println("ִ���޸�");
				result.setMessage("success");
				return result;
			}
		}
			conurseNoseService.addnode(courseNote);
			System.out.println("ִ�����");
		result.setMessage("success");
		return result;
	}
	@RequestMapping("/courseNote/ajax/querynote")
	@ResponseBody
	public String querynode(EduCourseNote courseNote,HttpSession session){
		Result result=new Result();
		Edu_User  user=	(Edu_User) session.getAttribute("login_success");
		courseNote.setUserId(user.getUser_id());
		courseNote = conurseNoseService.querynode(courseNote);
		result.setEntity(courseNote);
		return JsonUtils.objectToJson(result);
	}
}

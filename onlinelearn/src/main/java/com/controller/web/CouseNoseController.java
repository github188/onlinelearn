package com.controller.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.CourseCommentUser;
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
	@RequestMapping("/comment/webcomment2")
	public String comment2(Model model,int otherId){
		Map m=new HashMap<>();
		m.put("type", 2);
		m.put("other_id", otherId);
		List<CourseCommentUser> listallCourseComment = courseCommentService.listallCourseComment(m);
		if(listallCourseComment!=null&&listallCourseComment.size()>0){
			for(int i=0;i<listallCourseComment.size();i++){
				Map m2=new HashMap<>();
				m2.put("p_comment_id", listallCourseComment.get(i).getComment_id());
				System.out.println("��iD"+listallCourseComment.get(i).getComment_id());
				m2.put("type", 2);
				 List<CourseCommentUser> listallCourseCommentSon = courseCommentService.listallCourseCommentSon(m2);
				 System.out.println(listallCourseCommentSon.size());
				 if(listallCourseCommentSon!=null&&listallCourseCommentSon.size()>0){
					 listallCourseComment.get(i).setSon(listallCourseCommentSon);
					}
				 }
			}
		model.addAttribute("commentList",listallCourseComment);
		System.out.println("�������������󷽷�");
		return "web/course/comment";
	}
	@RequestMapping("/article/webcomment1")
	public String comment(Model model,int otherId){
		Map m=new HashMap<>();
		m.put("type", 2);
		m.put("other_id", otherId);
		List<CourseCommentUser> listallCourseComment = courseCommentService.listallCourseComment(m);
		if(listallCourseComment!=null&&listallCourseComment.size()>0){
			for(int i=0;i<listallCourseComment.size();i++){
				Map m2=new HashMap<>();
				m2.put("p_comment_id", listallCourseComment.get(i).getComment_id());
				System.out.println("��iD"+listallCourseComment.get(i).getComment_id());
				m2.put("type", 2);
				 List<CourseCommentUser> listallCourseCommentSon = courseCommentService.listallCourseCommentSon(m2);
				 System.out.println(listallCourseCommentSon.size());
				 if(listallCourseCommentSon!=null&&listallCourseCommentSon.size()>0){
					 listallCourseComment.get(i).setSon(listallCourseCommentSon);
					}
				 }
			}
		model.addAttribute("commentList",listallCourseComment);
		System.out.println(listallCourseComment.size());
		return "web/course/comment";
	}
	@RequestMapping("/tovedioplay")
	public String tovedioplay(Model model,int courseid){
		model.addAttribute("interfixCourse",conurseNoseService.byIdcourse(courseid));
		model.addAttribute("parentKpointList",kpointNoseService.listbyKpoint(courseid));
		model.addAttribute("SomeoneHas",eduNoseUserService.SomeoneHas(courseid));
		model.addAttribute("courseId",courseid);
		if(kpointNoseService.listbyKpoint(courseid)!=null&&kpointNoseService.listbyKpoint(courseid).size()>1){
			model.addAttribute("first",kpointNoseService.listbyKpoint(courseid).get(0).getKpoint_id());
		}
		return "web/course/player-video";
		}
	
	@RequestMapping("/ajax/getKopintHtml")
	public String getKopintHtml(Model model, HttpServletRequest request,@RequestParam("kpointId")int kpointId, HttpServletResponse response) {
		System.out.println(kpointId+"�ڵ�id");
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			EduCourseKpoint courseKpoint= kpointNoseService.bykopint(kpointId);
			System.out.println(courseKpoint.getVideo_type());
			// ���������ݲ���ȷʱֱ�ӷ���
			if (ObjectUtils.isNull(courseKpoint)) {
				out.println("<script>var noCover=true; dialog dialog('��ʾ','��������',1);</script>");
				return null;
			}
			
			//��ȡ�γ�
			EduCourse course = conurseNoseService.byIdcourse(courseKpoint.getCourse_id());
			if (course==null) {
				return "web/course/videocode";
			}
			model.addAttribute("courseKpoint",courseKpoint);
			model.addAttribute("course",course);
				// ��Ƶurl
			String videourl = courseKpoint.getVideo_url();
			System.out.println("��Ƶurl"+videourl);
				// ��������
			String videotype = courseKpoint.getVideo_type();
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

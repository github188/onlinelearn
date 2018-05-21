package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.EduCourse;
import com.bean.EduCourseNote;

public interface ConurseNoseMapper {

	List<EduCourse> listbyCourse(EduCourse course);
	EduCourse byIdcourse(int courseid);
	void addnode(EduCourseNote courseNote);
	void updatenode(EduCourseNote courseNote);
	EduCourseNote querynode(EduCourseNote courseNote);
	
	//�߼�����,��Ҫ���ڲ�ѯ��ѿγ�
	public List<EduCourse> listCourses(Map<Object, Object> map);
	//�û�id ��ѯ  �ղ�  �γ�
	public List<EduCourse> getFavoriteCourse(int user_id);
}

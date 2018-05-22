package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourse;
import com.bean.EduCourseFavorites;
import com.bean.EduCourseNote;

public interface ConurseNoseService {

	List<EduCourse> listbyCourse(EduCourse course);
	EduCourse byIdcourse(int courseid);
	void addnode(EduCourseNote courseNote);
	void updatenode(EduCourseNote courseNote);
	EduCourseNote querynode(EduCourseNote courseNote);
	boolean isNull(EduCourseFavorites courseFavorites);
	void addLove(EduCourseFavorites courseFavorites);
	List<EduCourse> bytime();
	List<EduCourse> byprice();
	List<EduCourse> byall();
	//�߼�����,��Ҫ������ѿγ�
	public List<EduCourse> listCourses(Map<Object, Object> map);
	//�����û�id ��ѯ�û� ��  �ղ�  �γ�
	public List<EduCourse> getFavoriteCourse(int user_id);
	//�����û�  id   �γ�id  ɾ��  �ղؿγ�
	public void deleteFaveoriteById(int user_id, int course_id);
	//���ݿγ��ַ���������ɾ��
	public void deleteFaveorite(int user_id, String courseIdStr);
}

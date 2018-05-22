package com.mapper;

import java.util.List;
import java.util.Map;
import com.bean.EduCourse;
import com.bean.EduCourseFavorites;
import com.bean.EduCourseNote;

public interface ConurseNoseMapper {

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
	//�߼�����,��Ҫ���ڲ�ѯ��ѿγ�
	public List<EduCourse> listCourses(Map<Object, Object> map);
	//�û�id ��ѯ  �ղ�  �γ�
	public List<EduCourse> getFavoriteCourse(int user_id);
	//�����û�  id   �γ�id  ɾ��  �ղؿγ�
	public void deleteFaveoriteById(Map<Object, Object> map);
}

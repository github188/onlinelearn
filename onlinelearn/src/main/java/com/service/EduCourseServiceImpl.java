package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EduCourse;
import com.bean.EduCourseKpoint;
import com.bean.TeacherBean;
import com.mapper.EduCourseMapper;
import com.vo.TreeVo;;

@Service
public class EduCourseServiceImpl implements EduCourseService{

	@Autowired
	private EduCourseMapper mapper;

	public void add(EduCourse course,String teacher_id){
		//��ӿγ̷����������ö���
		if (course != null) {
			mapper.add(course);
		}
		if (teacher_id != null) {
			//����ַ���,���ݿγ�id�ͽ�ʦid���   edu_course_teacher
			String teaIds[] = teacher_id.split(",");
			for (int i = 0; i < teaIds.length; i++) {
				Map<Object, Object> map = new HashMap<>();
				map.put("course_id", course.getCourse_id());
				map.put("teacher_id", Integer.valueOf(teaIds[i]));
				mapper.setTeacher(map);
			}
		}
	}

	//�˴���һ���߼�ɾ���γ�  ���ı�״̬Ϊ3
	public void remove(String course_id){
		if (course_id != null && course_id.trim().length() != 0) {
			mapper.remove(Integer.valueOf(course_id));
		}
	}


	//ͨ��ID�õ�һ�� �γ̶���
	public EduCourse getById(String course_id){
		if (course_id != null && course_id.trim().length() != 0) {
			return mapper.getById(Integer.valueOf(course_id));
		}
		return null;
	}

	public List<EduCourse> query(Map<Object, Object> map){
		return mapper.query(map);
	}


	@Override
	//ͨ���γ�id��ѯ�м���� ��ʦ����
	public List<TeacherBean> getTeacherByCourseId(String course_id) {
		if (course_id != null && course_id.trim().length() != 0) {
			List<TeacherBean> beans = mapper.getTeacherByCourseId(Integer.valueOf(course_id));
			return beans;
		}
		return null;
	}

	@Override
	//�޸Ŀγ�
	public void update(EduCourse course, String teacher_id) {
		if (course != null) {
			mapper.update(course);
		}
		//���   ��ʦ��   �ַ���,���ݿγ�id�ͽ�ʦid���   edu_course_teacher
		if (teacher_id != null) {
			//ɾ����   �γ�_ ��ʦ   ���й�ϵ
			mapper.removeCourseTeacher(course.getCourse_id());
			//ѭ�������   �γ�_ ��ʦ   �¹�ϵ
			String teaIds[]  = teacher_id.split(",");
			for (int i = 0; i < teaIds.length; i++) {
				Map<Object, Object> map = new HashMap<>();
				map.put("course_id", course.getCourse_id());
				if (teaIds[i]!=null && teaIds[i].trim().length() != 0) {
					map.put("teacher_id", Integer.valueOf(teaIds[i]));
				}
				mapper.setTeacher(map);
			}
		}
	}

	@Override
	public List<TreeVo> getCourseNodes(int course_id) {
		//���ظÿγ�����  �½����� ,���ΪZtree���ݷ���
		List<EduCourseKpoint> kpoints = mapper.getKpointByCourseId(course_id);
		List<TreeVo> vos = new ArrayList<>();
		for (EduCourseKpoint point : kpoints) {
			TreeVo vo = new TreeVo();
			vo.setId(point.getKpoint_id());
			vo.setName(point.getName());
			vo.setpId(point.getParent_id());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	//���½ڱ����ɾ������
	public void removeKpoint(int kpoint_id, int parent_id) {
		if (parent_id == 0) {//�����һ�����ڵ�
			//ɾ���ø��ڵ������нڵ�����
			mapper.removeKpointByParentId(kpoint_id);
		}
		//ɾ���ýڵ�
		mapper.removeKpointById(kpoint_id);
	}

	@Override
	//�����½ڸ��ڵ�
	public void addKpointParent(EduCourseKpoint kpoint) {
		if (kpoint != null) {
			mapper.addKpointParent(kpoint);
		}
	}

	@Override
	//��ӽڵ�
	public void addKpoint(EduCourseKpoint kpoint) {
		if (kpoint != null) {
			mapper.addKpoint(kpoint);
		}
		
	}

	@Override
	//ͨ��ID��ѯ�ýڵ����ݲ�����
	public EduCourseKpoint getKpointById(int kpoint_id) {
		if(kpoint_id > 0){
			return mapper.getKpointById(kpoint_id);
		}
		return null;
	}

	@Override
	//�޸Ľڵ�
	public void updateKpoint(EduCourseKpoint kpoint) {
		if (kpoint != null) {
			mapper.updateKpoint(kpoint);
		}
	}
}

package com.mapper;

import java.util.List;
import java.util.Map;
import com.bean.EduCourse;
import com.bean.EduCourseKpoint;
import com.bean.TeacherBean;

public interface EduCourseMapper {
	
	public void remove(int course_id);
	
	public void update(EduCourse course);
	
	public EduCourse getById(int course_id);
	
	public List<EduCourse> query(Map<Object, Object> map);
	
	public void add(EduCourse course);

	public int setTeacher(Map<Object, Object> map);
	
	public List<TeacherBean> getTeacherByCourseId(int course_id);
	
	public void removeCourseTeacher(int course_id);

	/** ͨ���γ�id ��ѯ���е�  �ÿγ��µ������½�
	 * @param course_id
	 * @return List<EduCourseKpoint>
	 */
	public List<EduCourseKpoint> getKpointByCourseId(int course_id);

	/** ɾ��  edu_course_kpoint �� ��  ���и�id�� �� ���� 
	 * @param parent_id
	 */
	public void removeKpointByParentId(int parent_id);

	/*ɾ��  edu_course_kpoint �� ��  ���� ͨ��id
	 * @param kpoint_id
	 */
	public void removeKpointById(int kpoint_id);

	/** �����½ڸ��ڵ�
	 * @param kpoint
	 */
	public void addKpointParent(EduCourseKpoint kpoint);

	/**����ӽڵ�
	 * @param kpoint
	 */
	public void addKpoint(EduCourseKpoint kpoint);

	/**ͨ��Id��ѯ��һ��Kpoint���󷵻�
	 * @param kpoint_id
	 * @return EduCourseKpoint
	 */
	public EduCourseKpoint getKpointById(int kpoint_id);

	/**�޸Ľڵ�
	 * @param kpoint
	 */
	public void updateKpoint(EduCourseKpoint kpoint);

}

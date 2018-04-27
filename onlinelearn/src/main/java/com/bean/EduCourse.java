package com.bean;

import java.util.Date;

public class EduCourse {
	
//	  `COURSE_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '�γ̱��',
//	  `COURSE_NAME` varchar(300) NOT NULL DEFAULT '' COMMENT '�γ�����',
//	  `IS_AVALIABLE` int(10) NOT NULL DEFAULT '0' COMMENT '1����2ɾ��',
//	  `SUBJECT_ID` int(11) DEFAULT '0' COMMENT '�γ�רҵID',
//	  `ADD_TIME` timestamp NULL DEFAULT NULL COMMENT '���ʱ��',
//	  `SOURCE_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '�γ�ԭ�۸�ֻ��ʾ��',
//	  `CURRENT_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '�γ����ۼ۸�ʵ��֧���۸�����Ϊ0�����ѹۿ�',
//	  `TITLE` varchar(200) NOT NULL DEFAULT '' COMMENT '�γ̼��',
//	  `CONTEXT` longtext NOT NULL COMMENT '�γ�����',
//	  `LESSION_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '�ܿ�ʱ',
//	  `LOGO` varchar(200) NOT NULL DEFAULT '' COMMENT 'ͼƬ·��',
//	  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '������ʱ��',
//	  `PAGE_BUYCOUNT` int(11) DEFAULT '0' COMMENT '��������',
//	  `PAGE_VIEWCOUNT` int(11) NOT NULL DEFAULT '0' COMMENT '�������',
//	  `END_TIME` timestamp NULL DEFAULT NULL COMMENT '��Ч����ʱ��',
//	  `LOSETYPE` int(2) DEFAULT '0' COMMENT '��Ч�����ͣ�0������ʱ�䣬1��������',
//	  `LOSE_TIME` varchar(255) DEFAULT NULL COMMENT '��Ч��:��Ʒ��������ʱ���',
//	  `SEQUENCE` int(1) DEFAULT '0' COMMENT '����',
//	  `COURSE_GROSS_INCOME` decimal(10,2) DEFAULT '0.00' COMMENT '�ÿγ��ܹ����˶���Ǯ���¼��ֶ���ʱû�õ���'
	
	private int course_id;       //�γ̱��
	private String course_name; //�γ�����
	private int is_avaliable;    //1����2ɾ��
	private SysSubject subject;  //�γ�רҵID
	private Date add_time;       //���ʱ��
	private int source_price;    //�γ�ԭ�۸�ֻ��ʾ��
	private int current_price;   //�γ����ۼ۸�ʵ��֧���۸�����Ϊ0�����ѹۿ�
	private String title;        //�γ̼��
	private String context;      //�γ�����
	private int lession_num;     //�ܿ�ʱ
	private String logo;         //ͼƬ·��
	private Date update_time;    //������ʱ��
	private int page_buyCount;   //��������
	private int page_viewCount;  //�������
	private Date end_time;       //��Ч����ʱ��
	private int lose_type;       //��Ч�����ͣ�0������ʱ�䣬1��������
	private String lose_time;    //��Ч��:��Ʒ��������ʱ���
	private int sequence;        //����
	
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getIs_avaliable() {
		return is_avaliable;
	}
	public void setIs_avaliable(int is_avaliable) {
		this.is_avaliable = is_avaliable;
	}
	public SysSubject getSubject() {
		return subject;
	}
	public void setSubject(SysSubject subject) {
		this.subject = subject;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public int getSource_price() {
		return source_price;
	}
	public void setSource_price(int source_price) {
		this.source_price = source_price;
	}
	public int getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(int current_price) {
		this.current_price = current_price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getLession_num() {
		return lession_num;
	}
	public void setLession_num(int lession_num) {
		this.lession_num = lession_num;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getPage_buyCount() {
		return page_buyCount;
	}
	public void setPage_buyCount(int page_buyCount) {
		this.page_buyCount = page_buyCount;
	}
	public int getPage_viewCount() {
		return page_viewCount;
	}
	public void setPage_viewCount(int page_viewCount) {
		this.page_viewCount = page_viewCount;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getLose_type() {
		return lose_type;
	}
	public void setLose_type(int lose_type) {
		this.lose_type = lose_type;
	}
	public String getLose_time() {
		return lose_time;
	}
	public void setLose_time(String lose_time) {
		this.lose_time = lose_time;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	@Override
	public String toString() {
		return "EduCourse [course_id=" + course_id + ", course_name=" + course_name + ", is_avaliable=" + is_avaliable
				+ ", subject=" + subject + ", add_time=" + add_time + ", source_price=" + source_price
				+ ", current_price=" + current_price + ", title=" + title + ", CONTEXT=" + context + ", lession_num="
				+ lession_num + ", logo=" + logo + ", update_time=" + update_time + ", page_buyCount=" + page_buyCount
				+ ", page_viewCount=" + page_viewCount + ", end_time=" + end_time + ", lose_type=" + lose_type
				+ ", lose_time=" + lose_time + ", sequence=" + sequence + "]";
	}

}

package com.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class WebTeacherBean {
	private Integer course_id;//�γ̱��
    private String course_name;//�γ�����
    private Integer is_avaliable;//�γ�״̬  1�����ϼ�  2�������¼�
    private Integer subject_id;//�γ�רҵid
    private String subject_link;//�γ�רҵ��
    private Date add_time;//���ʱ��
    private BigDecimal source_price;//�γ�ԭ��
    private BigDecimal current_price;//�γ����ۼ۸�ʵ��֧���۸�����Ϊ0�����ѹۿ�
    private String title;//�γ̼��
    private Integer lession_num;//�ܿ�ʱ
    private String logo;//ͼƬ·��
    private Date update_time;//������ʱ��
    private Integer page_buycount;//��������
    private Integer page_viewcount;//�������
    private Date end_time;//��Ч����ʱ��
    private Integer losetype;//��Ч������ 0 ����ʱ��  1 ������
    private String lose_time;//��Ч�� ��Ʒ��������ʱ���
    private Integer sequence;//����
    private BigDecimal course_gross_income;//�ÿγ��ܹ����˶���Ǯ
    private String context; //�γ�����
    private SysSubject subject;
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Integer getIs_avaliable() {
		return is_avaliable;
	}
	public void setIs_avaliable(Integer is_avaliable) {
		this.is_avaliable = is_avaliable;
	}
	public Integer getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_link() {
		return subject_link;
	}
	public void setSubject_link(String subject_link) {
		this.subject_link = subject_link;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public BigDecimal getSource_price() {
		return source_price;
	}
	public void setSource_price(BigDecimal source_price) {
		this.source_price = source_price;
	}
	public BigDecimal getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(BigDecimal current_price) {
		this.current_price = current_price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getLession_num() {
		return lession_num;
	}
	public void setLession_num(Integer lession_num) {
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
	public Integer getPage_buycount() {
		return page_buycount;
	}
	public void setPage_buycount(Integer page_buycount) {
		this.page_buycount = page_buycount;
	}
	public Integer getPage_viewcount() {
		return page_viewcount;
	}
	public void setPage_viewcount(Integer page_viewcount) {
		this.page_viewcount = page_viewcount;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Integer getLosetype() {
		return losetype;
	}
	public void setLosetype(Integer losetype) {
		this.losetype = losetype;
	}
	public String getLose_time() {
		return lose_time;
	}
	public void setLose_time(String lose_time) {
		this.lose_time = lose_time;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public BigDecimal getCourse_gross_income() {
		return course_gross_income;
	}
	public void setCourse_gross_income(BigDecimal course_gross_income) {
		this.course_gross_income = course_gross_income;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public SysSubject getSubject() {
		return subject;
	}
	public void setSubject(SysSubject subject) {
		this.subject = subject;
	}
    
    

}

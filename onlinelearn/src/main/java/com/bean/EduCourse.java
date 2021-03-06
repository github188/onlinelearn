package com.bean;

import java.util.Date;

public class EduCourse {

	//	  `COURSE_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
	//	  `COURSE_NAME` varchar(300) NOT NULL DEFAULT '' COMMENT '课程名称',
	//	  `IS_AVALIABLE` int(10) NOT NULL DEFAULT '0' COMMENT '1正常2删除',
	//	  `SUBJECT_ID` int(11) DEFAULT '0' COMMENT '课程专业ID',
	//	  `ADD_TIME` timestamp NULL DEFAULT NULL COMMENT '添加时间',
	//	  `SOURCE_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '课程原价格（只显示）',
	//	  `CURRENT_PRICE` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '课程销售价格（实际支付价格）设置为0则可免费观看',
	//	  `TITLE` varchar(200) NOT NULL DEFAULT '' COMMENT '课程简介',
	//	  `CONTEXT` longtext NOT NULL COMMENT '课程详情',
	//	  `LESSION_NUM` int(11) NOT NULL DEFAULT '0' COMMENT '总课时',
	//	  `LOGO` varchar(200) NOT NULL DEFAULT '' COMMENT '图片路径',
	//	  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
	//	  `PAGE_BUYCOUNT` int(11) DEFAULT '0' COMMENT '销售数量',
	//	  `PAGE_VIEWCOUNT` int(11) NOT NULL DEFAULT '0' COMMENT '浏览数量',
	//	  `END_TIME` timestamp NULL DEFAULT NULL COMMENT '有效结束时间',
	//	  `LOSETYPE` int(2) DEFAULT '0' COMMENT '有效期类型，0：到期时间，1：按天数',
	//	  `LOSE_TIME` varchar(255) DEFAULT NULL COMMENT '有效期:商品订单过期时间点',
	//	  `SEQUENCE` int(1) DEFAULT '0' COMMENT '序列',
	//	  `COURSE_GROSS_INCOME` decimal(10,2) DEFAULT '0.00' COMMENT '该课程总共卖了多少钱（新加字段暂时没用到）'

	private int course_id;       //-课程编号
	private String course_name; //-课程名称
	private int is_avaliable;    //-1正常2删除
	private SysSubject subject;  //-课程专业ID
	private String subject_link;  //-课程专业ID
	private Date add_time;       //-添加时间
	private double source_price;    //-课程原价格（只显示）
	private double current_price;   //-课程销售价格（实际支付价格）设置为0则可免费观看
	private String title;        //-课程简介
	private String context;      //-课程详情
	private int lession_num;     //-总课时
	private String logo;         //-图片路径
	private Date update_time;    //-最后更新时间
	private int page_buyCount;   //销售数量
	private int page_viewCount;  //浏览数量
	private Date end_time;       //-有效结束时间
	private int loseType;       //-有效期类型，0：到期时间，1：按天数
	private String lose_time;    //-有效期:商品订单过期时间点
	private int sequence;        //序列
	private int Sid;//用于前台课程
	private int Tid;//用于前台课程
	private int subject_id;//用于前台课程
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}

	//	course_name
	//	parent_id
	//	subject_id
	//	is_avaliable
	//	lession_num
	//	source_price
	//	current_price
	//	loseType
	//	lose_time
	//	endTime
	//	teacher_id
	//	titles
	//	logo1
	//	context
	//	


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
	public double getSource_price() {
		return source_price;
	}
	public void setSource_price(double source_price) {
		this.source_price = source_price;
	}
	public double getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(double current_price) {
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
	public int getLoseType() {
		return loseType;
	}
	public void setLoseType(int loseType) {
		this.loseType = loseType;
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
	public String getSubject_link() {
		return subject_link;
	}
	public void setSubject_link(String subject_link) {
		this.subject_link = subject_link;
	}

	@Override
	public String toString() {
		return "EduCourse [course_id=" + course_id + ", course_name=" + course_name + ", is_avaliable=" + is_avaliable
				+ ", subject=" + subject + ", subject_link=" + subject_link + ", add_time=" + add_time
				+ ", source_price=" + source_price + ", current_price=" + current_price + ", title=" + title
				+ ", context=" + context + ", lession_num=" + lession_num + ", logo=" + logo + ", update_time="
				+ update_time + ", page_buyCount=" + page_buyCount + ", page_viewCount=" + page_viewCount
				+ ", end_time=" + end_time + ", loseType=" + loseType + ", lose_time=" + lose_time + ", sequence="
				+ sequence + "]";
	}

}

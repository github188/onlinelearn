package com.bean;

import java.sql.Timestamp;
import java.util.Date;

public class CourseCommentUser {
	
	private int comment_id;   //ID
	private Edu_User user;      //�û�id
	private int p_comment_id;  //��������id(Ϊ0����һ������,��Ϊ0���ǻظ�)
	private String content;  //��������
	private Date addtime;   //����ʱ��
	private int other_id;   //���۵����id
	private int praise_count;  //��������
	private int  reply_count;   //�ظ�����
	private int type;         //1���� 2�γ�
	
	
	private int user_id;//�û�Id
	private String mobile;//�ֻ���
	private String email;//�����
	private String password;//����
	private String user_name;//�û���
	private String show_name;//��ʾ�� ���ǳƣ�
	private int sex;//�Ա�  1��  2Ů
	private int age;//����
	private Timestamp create_time;//ע��ʱ��
	private int is_avalible;//�Ƿ����
	private String pic_img;//�û�ͷ��
	private String banner_url;//���������û�����ͼƬ
	private int msg_num;//վ����δ����Ϣ��
	private int sys_msg_num;//0
	private Timestamp last_system_time;//�ϴ�ͳ��ϵͳ��Ϣʱ��
	private String start;
	private String end;
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Edu_User getUser() {
		return user;
	}
	public void setUser(Edu_User user) {
		this.user = user;
	}
	public int getP_comment_id() {
		return p_comment_id;
	}
	public void setP_comment_id(int p_comment_id) {
		this.p_comment_id = p_comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public int getOther_id() {
		return other_id;
	}
	public void setOther_id(int other_id) {
		this.other_id = other_id;
	}
	public int getPraise_count() {
		return praise_count;
	}
	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getShow_name() {
		return show_name;
	}
	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public int getIs_avalible() {
		return is_avalible;
	}
	public void setIs_avalible(int is_avalible) {
		this.is_avalible = is_avalible;
	}
	public String getPic_img() {
		return pic_img;
	}
	public void setPic_img(String pic_img) {
		this.pic_img = pic_img;
	}
	public String getBanner_url() {
		return banner_url;
	}
	public void setBanner_url(String banner_url) {
		this.banner_url = banner_url;
	}
	public int getMsg_num() {
		return msg_num;
	}
	public void setMsg_num(int msg_num) {
		this.msg_num = msg_num;
	}
	public int getSys_msg_num() {
		return sys_msg_num;
	}
	public void setSys_msg_num(int sys_msg_num) {
		this.sys_msg_num = sys_msg_num;
	}
	public Timestamp getLast_system_time() {
		return last_system_time;
	}
	public void setLast_system_time(Timestamp last_system_time) {
		this.last_system_time = last_system_time;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

}

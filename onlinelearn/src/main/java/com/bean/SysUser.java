package com.bean;

import java.util.Date;

public class SysUser {

//	  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
//	  `LOGIN_NAME` varchar(20) NOT NULL DEFAULT '' COMMENT '��¼��',
//	  `LOGIN_PWD` varchar(32) NOT NULL DEFAULT '' COMMENT '��¼����',
//	  `USER_NAME` varchar(50) DEFAULT NULL COMMENT '�û���ʵ������',
//	  `STATUS` tinyint(1) DEFAULT '0' COMMENT '״̬.0: ����,1:����,2��ɾ��',
//	  `LAST_LOGIN_TIME` timestamp NULL DEFAULT NULL COMMENT '����¼ʱ��',
//	  `LAST_LOGIN_IP` varchar(20) DEFAULT NULL COMMENT '����¼IP',
//	  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '����ʱ��',
//	  `EMAIL` varchar(50) DEFAULT NULL COMMENT '�ʼ���ַ',
//	  `TEL` varchar(12) DEFAULT NULL COMMENT '�ֻ�����',
//	  `ROLE_ID` int(11) DEFAULT '0' COMMENT '������ɫID',
//	  PRIMARY KEY (`USER_ID`)
	
	private int user_id;            //����
	private String login_name;      //��¼��
	private String login_pwd;       //��¼����
	private String user_name;       //�û���ʵ����
	private int status;             //״̬.0: ����,1:����,2:ɾ��
	private String last_login_time; //����¼ʱ��
	private String last_login_ip;   //����¼IP
	private Date create_time;       //����ʱ��
	private String email;           //�ʼ���ַ
	private String tel;             //�ֻ�����
	private SysRole role;           //��ɫ
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(String last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	
	public SysUser() {
		
	}
	
	public SysUser(int user_id, String login_name, String login_pwd, String user_name, int status,
			String last_login_time, String last_login_ip, Date create_time, String email, String tel, SysRole role) {
		super();
		this.user_id = user_id;
		this.login_name = login_name;
		this.login_pwd = login_pwd;
		this.user_name = user_name;
		this.status = status;
		this.last_login_time = last_login_time;
		this.last_login_ip = last_login_ip;
		this.create_time = create_time;
		this.email = email;
		this.tel = tel;
		this.role = role;
	}
	
	public SysUser(int user_id, String login_name, String login_pwd, String user_name, int status, Date create_time,
			String tel, SysRole role) {
		super();
		this.user_id = user_id;
		this.login_name = login_name;
		this.login_pwd = login_pwd;
		this.user_name = user_name;
		this.status = status;
		this.create_time = create_time;
		this.tel = tel;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Sys_User [user_id=" + user_id + ", login_name=" + login_name + ", login_pwd=" + login_pwd
				+ ", user_name=" + user_name + ", status=" + status + ", create_time=" + create_time + ", tel=" + tel
				+ ", role=" + role + "]";
	}
	
}

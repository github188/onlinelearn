package com.bean;

import java.util.Date;

public class SysFunction {

//	  `FUNCTION_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Ȩ��ID',
//	  `PARENT_ID` int(11) DEFAULT '0' COMMENT 'Ȩ�޸�ID',
//	  `FUNCTION_NAME` varchar(100) DEFAULT NULL COMMENT 'Ȩ����',
//	  `FUNCTION_URL` varchar(255) DEFAULT NULL COMMENT 'Ȩ��URL',
//	  `FUNCTION_TYPE` tinyint(1) DEFAULT '0' COMMENT 'Ȩ������ 1�˵� 2����',
//	  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '����ʱ��',
//	  `SORT` int(11) DEFAULT '0' COMMENT '����',
	
	private int function_id;
	private int parent_id;        //Ȩ�޸�ID
	private String function_name; //Ȩ����
	private String function_url;  //Ȩ��URL
	private int function_type;    //Ȩ������ 1�˵� 2����
	private Date create_time;     //����ʱ��
	private int sort;             //����
	private String function_alias;//����
	
	
	public int getFunction_id() {
		return function_id;
	}
	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getFunction_name() {
		return function_name;
	}
	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}
	public String getFunction_url() {
		return function_url;
	}
	public void setFunction_url(String function_url) {
		this.function_url = function_url;
	}
	public int getFunction_type() {
		return function_type;
	}
	public void setFunction_type(int function_type) {
		this.function_type = function_type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getFunction_alias() {
		return function_alias;
	}
	public void setFunction_alias(String function_alias) {
		this.function_alias = function_alias;
	}
	public SysFunction(int function_id, int parent_id, String function_name, String function_url, int function_type,
			Date create_time, int sort,String function_alias) {
		super();
		this.function_id = function_id;
		this.parent_id = parent_id;
		this.function_name = function_name;
		this.function_url = function_url;
		this.function_type = function_type;
		this.create_time = create_time;
		this.sort = sort;
		this.function_alias = function_alias;
	}
	
	@Override
	public String toString() {
		return "SysFunction [function_id=" + function_id + ", parent_id=" + parent_id + ", function_name="
				+ function_name + ", function_url=" + function_url + ", function_type=" + function_type
				+ ", create_time=" + create_time + ", sort=" + sort + ", function_alias=" + function_alias + "]";
	}
	
	public SysFunction() {
		// TODO Auto-generated constructor stub
	}
	

	
}

package com.bean;

public class TreeBean {
	private int id;
	private int pId;  //�ڵ�ĸ�id
	private String name; //�ڵ������
	private boolean open=true; //�ڵ��Ƿ�չ��
	private boolean checked=false; //�ڵ��Ƿ�ѡ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

}

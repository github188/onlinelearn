package com.bean;

import java.util.Date;

public class Comment {

	private int comment_id;   //ID
	private Edu_User user_id;      //�û�id
	private int p_comment_id;  //��������id(Ϊ0����һ������,��Ϊ0���ǻظ�)
	private String content;  //��������
	private String addtime;   //����ʱ��
	private int other_id;   //���۵����id
	private int praise_count;  //��������
	private int  reply_count;   //�ظ�����
	private int type;         //1���� 2�γ�
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Edu_User getUser_id() {
		return user_id;
	}
	public void setUser_id(Edu_User user_id) {
		this.user_id = user_id;
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
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
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
	
	
	
	
	
	
	
	
	
	
	
	
}

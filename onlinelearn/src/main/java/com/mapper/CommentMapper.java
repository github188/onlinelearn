package com.mapper;

import java.util.List;
import java.util.Map;

import com.bean.Comment;

public interface CommentMapper {
	
	public  List<Comment> listAll(Map map);
	public  void  save(Comment comment);
	public  void  detele(int comment_id);
	public  Comment  getById(int comment_id);
	public List<Comment> listComment(int other_id);
	public  void praiseEdit(int comment_id);
	public List<Comment> childComment(Map map);
	public  void addcomment(int comment_id);
	public void addNum(int other_id);
	public List<Comment> selectId(int comment_id);

	
}

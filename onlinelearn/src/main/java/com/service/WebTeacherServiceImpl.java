package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.WebTeacherBean;
import com.mapper.WebTeacherMapper;

@Service
public class WebTeacherServiceImpl implements WebTeacherService{
	@Autowired
	private WebTeacherMapper webTeacherMapper;

	@Override
	public List<WebTeacherBean> list(int id) {
		List<WebTeacherBean> list =webTeacherMapper.list(id);
		return list;
	}

}

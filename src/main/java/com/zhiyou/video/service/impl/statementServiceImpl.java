package com.zhiyou.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.StatementMapper;
import com.zhiyou.video.service.statementService;

@Service
public class statementServiceImpl implements statementService{

	@Autowired
	StatementMapper sm;
	
	@Override
	public List<Integer> findStatement() {
		List<Integer> list = sm.selectAvg();
		//System.out.println("2测试平均数"+list);
		return list;
	}

	
}

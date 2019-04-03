package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.four.server.dsm.EntityDaoHibernate;


@Service
public class StudentServiceImpl extends EntityDaoHibernate implements IStudentService {
	private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public void test(String sql) {
		
	try {
		this.execUpdateThrowE(sql);
	} catch (Exception e) {
		logger.info("保存数据失败"+sql);
		e.printStackTrace();
	}
	  
		
	}

	@Override
	public String findUser(String sql) {
		return this.findBySql(sql, null).get(0).toString();
	}

	
	

}

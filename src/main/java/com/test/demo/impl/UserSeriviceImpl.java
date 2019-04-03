package com.test.demo.impl;

import com.test.demo.UserService;

public class UserSeriviceImpl implements UserService {

	@Override
	public String getName(String args) {
		System.out.println("执行业务逻辑");
		return "业务逻辑"+args;
	}

}

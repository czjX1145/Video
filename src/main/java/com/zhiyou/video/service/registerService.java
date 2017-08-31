package com.zhiyou.video.service;

import com.zhiyou.video.model.User;

public interface registerService {

	Boolean registerUser(User user);

	User findLoginUser(User user);
	
	User findLoginUser2(User user);

	Boolean addTestId(User user, int uuid);

	User findTestId(User user);

	int updataPwd(User user);
     
	int updateUser(User user);

	User findLoginUser(String email);

	
	
}

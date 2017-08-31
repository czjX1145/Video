package com.zhiyou.video.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.UserMapper;
import com.zhiyou.video.model.User;
import com.zhiyou.video.model.UserExample;
import com.zhiyou.video.model.UserExample.Criteria;
import com.zhiyou.video.service.registerService;
@Service
public class registerServiceImpl implements registerService {

	@Autowired
	UserMapper um;
	//注册
	@Override
	public Boolean registerUser(User user) {
		UserExample example = new UserExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(user.getEmail());
		List<User> list = um.selectByExample(example);					
		if(!list .isEmpty()){
			return false;
			}	 
		else {
			um.insert(user);
			return true;
		  }
		
	}
	
    //登录
	@Override
	public User findLoginUser(User user) {
		User user2 = null;
		UserExample example = new UserExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());		
		List<User> list = um.selectByExample(example);
		if(!list.isEmpty()){
			user2 = list.get(0);
			return user;
		}
		else{			
			return null;
		}		
	}
	
	//查找已经登录的用户
	@Override
	public User findLoginUser(String email) {
		UserExample example = new UserExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<User> list = um.selectByExample(example);
		User user = list.get(0);
		return user;
	}
	
	
    //插入验证码
	@Override
	public Boolean addTestId(User user, int uuid) {
        user.setCaptcha(""+uuid);
        UserExample example = new UserExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(user.getEmail());	
		int i = um.updateByExampleSelective(user, example);		
		if(i != 0){
			return true;
		}else {
			return false;
		}
		
	}
    //查找邮箱以及验证码
	@Override
	public User findTestId(User user) {
		 UserExample example = new UserExample(); 
		 Criteria criteria = example.createCriteria();
		 criteria.andEmailEqualTo(user.getEmail()).andCaptchaEqualTo(user.getCaptcha());		 		 
         List<User> list = um.selectByExample(example);
         if(!list.isEmpty()){
        	return list.get(0);
         }else{
        	 return null;
         }        		
	}

	//更新   新密码
	@Override
	public int updataPwd(User user) {
		 UserExample example = new UserExample(); 
		 Criteria criteria = example.createCriteria();
		 criteria.andEmailEqualTo(user.getEmail());
		 int i = um.updateByExampleSelective(user, example);
		return i;
	}
	
    //更新用户资料
	@Override
	public int updateUser(User user) {
		UserExample example = new UserExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(user.getEmail());
        int i = um.updateByExampleSelective(user, example);
		return i;
	}

	@Override
	public User findLoginUser2(User user) {
		User user2 = null;
		UserExample example = new UserExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());		
		List<User> list = um.selectByExample(example);
		if(!list.isEmpty()){
			user2 = list.get(0);
			return user;
		}
		else{			
			return null;
		}		
	}

	

}

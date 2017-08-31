package com.zhiyou.video.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhiyou.video.mapper.AdminMapper;
import com.zhiyou.video.model.Admin;
import com.zhiyou.video.model.AdminExample;
import com.zhiyou.video.model.AdminExample.Criteria;
import com.zhiyou.video.service.adminService;
@Service
public class adminServiceImpl implements adminService {

	@Autowired
	AdminMapper am;
	@Override
	public Admin findAdmin(Admin ad) {
		AdminExample example = new AdminExample();
        ad.setLoginPwd(DigestUtils.md5DigestAsHex(ad.getLoginPwd().getBytes())); 
		Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(ad.getLoginName()).andLoginPwdEqualTo(ad.getLoginPwd());
		List<Admin> list = am.selectByExample(example);		
		if(list != null){
			for (Admin admin : list) {
				return admin;
			}			
		}
		return null;		
	}

}

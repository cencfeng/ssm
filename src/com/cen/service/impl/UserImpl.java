package com.cen.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cen.entity.Moudle;
import com.cen.entity.User;
import com.cen.mapper.UserMapper;
import com.cen.service.Userservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class UserImpl implements Userservice {

	@Autowired
	UserMapper usermapper;
	@Override
	public User getUserbyname(User user) {
		// TODO Auto-generated method stub
		return usermapper.getUserbyname(user);
		
	}
	@Override
	public List<Moudle> getMoudle(String username) {
		// TODO Auto-generated method stub
		return usermapper.getMoudle(username);
	}
	@Override
	public List<Moudle> getSubMoudle(int moudleid) {
		// TODO Auto-generated method stub
		return usermapper.getSubMoudle(moudleid);
	}
	@Override
	public void ResetPassword(User user) {
		// TODO Auto-generated method stub
		usermapper.resetPassword(user);
	}

}

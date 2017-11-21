package com.cen.service;

import java.util.List;

import com.cen.entity.Moudle;
import com.cen.entity.User;

public interface Userservice {

	public User getUserbyname(User user);
	public List<Moudle> getMoudle(String username);
	public List<Moudle> getSubMoudle(int moudleid);
	public void ResetPassword(User user);
}

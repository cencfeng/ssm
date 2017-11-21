package com.cen.mapper;

import java.util.List;

import com.cen.entity.Moudle;
import com.cen.entity.User;

public interface UserMapper {

	public User getUserbyname(User user);
	public List<Moudle> getMoudle(String username);
	public List<Moudle> getSubMoudle(int moudleid);
	public void resetPassword(User user);
}

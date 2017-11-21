package com.cen.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.cen.entity.Moudle;
import com.cen.entity.User;
import com.cen.service.Userservice;
@Controller
@SessionAttributes("username")
@RequestMapping("User")
public class UserController {

	@Autowired
	Userservice userservice;
	
	
	@RequestMapping("/login")
	public String login(User user,HttpSession httpSession)
	{
		user= userservice.getUserbyname(user);
		if(user!=null)
		{
			httpSession.setAttribute("username", user.getUsername());
			return "login";
		}
		return "failed";
	}
	
	@RequestMapping(value="/getMoudle", method=RequestMethod.POST)
	@ResponseBody
	public List<Moudle> getMoudle(String username) throws Exception
	{
		List<Moudle> moudleList=new ArrayList<Moudle>();
		moudleList=userservice.getMoudle(username);
		return moudleList;
	}
	@RequestMapping(value="/getSubMoudle",method=RequestMethod.POST)
	@ResponseBody
	public List<Moudle> getSubMoudle(int moudleid)
	{
		List<Moudle> submoudleList=new ArrayList<Moudle>();
		submoudleList=userservice.getSubMoudle(moudleid);
		return submoudleList;
	}
	
	@RequestMapping("/modify")
	public String mPassword(HttpSession httpSession)
	{
		return "modify";
		
	}
	
	@RequestMapping("/resetPassword")
	public String resetPassword(User user) {
		userservice.ResetPassword(user);
		return "modify";
	}
	
	@RequestMapping("/resetPassword2")
	@ResponseBody
	public String resetPassword2(String username,String oldpassword,String newpassword)
	{
		User user=new User();
		user.setUsername(username);
		user.setPassword(oldpassword);
		user=userservice.getUserbyname(user);
		if(user!=null)
		{
			User user1=new User();
			user1.setUsername(username);
			user1.setPassword(newpassword);
			userservice.ResetPassword(user1);
			return "ok";		
		}else {
			return "f";
		}
		
	}
}

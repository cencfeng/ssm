package com.cen.controller;
import java.util.List;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cen.entity.File;
import com.cen.service.Consumerservice;
import com.cen.service.Fileservice;
import com.cen.service.Producerservice;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/File")
public class FileController {

	@Autowired
    Destination demoQueueDestination;
	@Autowired
	Fileservice fileservice;
	@Autowired
	Producerservice producerService;
	@Autowired
	Consumerservice consumerService;
	@RequestMapping("/upload")
	public String uploadFile()
	{
		return "fileUpload";
	}
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	public String fileUpLoad(HttpServletRequest request,@RequestParam("file") MultipartFile file,Model m) throws Exception
	{
		List<File> list = fileservice.SaveFile(file, request);
		m.addAttribute("myfile", list);
		return "file/test";
	}
	
	@RequestMapping("/writeAndRead")
	public String writeAndRead()
	{
		return "file/writeAndRead";
	}
	@RequestMapping("/write")
	public String WriteIN(String textIn) throws Exception
	{
		fileservice.WrieToFile(textIn);
		return "success";
	}
	@RequestMapping("/activemqSend")
	public String activeMqSend()
	{
		return "file/activemqSend";
	}
	@RequestMapping("/activemq")
	public String activeMQ(String textMsg) throws Exception
	{
		//JedisShardInfo  jedisShardInfo = new JedisShardInfo("192.168.214.129", 6379);
        //jedisShardInfo.setPassword("123456");//密码认证
        Jedis jedis = new Jedis("192.168.214.129", 6379);
        //jedis.auth("123456");
		jedis.set("name","xiaoting");
		jedis.close();
		producerService.sendMSG(demoQueueDestination,textMsg);
		return "success";
		
	}
	@RequestMapping("/activemqReceive")
	public ModelAndView activemqR() throws Exception
	{
		String message = consumerService.receive(demoQueueDestination);
		ModelAndView mvAndView = new ModelAndView("file/activemqReceive","message",message);
		return mvAndView;
		
	}
	
	@RequestMapping("/jedisTest")
	public String jedisTest()
	{
	    //JedisConnection connection = null;
	    //connection = (JedisConnection) jedisConnectionFactory.getConnection();
	    
		return "file/jedisTest";
	}
}

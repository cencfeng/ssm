package com.cen.service.impl;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cen.entity.File;
import com.cen.mapper.FileMapper;
import com.cen.service.Fileservice;
@Service
public class FileImpl implements Fileservice {

	@Autowired
	FileMapper filemapper;
	@Override
	@Transactional
	public List<File> SaveFile(MultipartFile file,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String path=null;
		String parentpath=null;
		Date date = new Date();
		File upfile=new File();
		List<File> list=new ArrayList<File>();
		if(!file.isEmpty())
		{	
			String filename=file.getOriginalFilename();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		    String strdate = sdf.format(date);
		    String fileno=strdate+filename.hashCode();
		    String prefix=filename.substring(filename.lastIndexOf(".")+1);
			parentpath = "D:/file/";
			path=parentpath+fileno+"."+prefix;
			java.io.File f=new java.io.File(parentpath);
			upfile.setFileno(fileno);
			upfile.setFilename(filename);
			upfile.setFilepath(path);
			if(!f.exists())
			{
				f.mkdirs();
			}
			file.transferTo(new java.io.File(path));
			filemapper.saveFile(upfile);
			list.add(upfile);
			//throw new NullPointerException("编号为空");
		}
		return list;
	}
	@Override
	public void WrieToFile(String myContext) throws Exception {
		// TODO Auto-generated method stub
		
	    java.io.File file=new java.io.File("D:/file/input.txt");
		//FileWriter fw = new FileWriter(file,true);//使用FileWriter写入
	    //FileReader reader = new FileReader(file);// 获取该文件的输入流  
	    FileInputStream fi=new FileInputStream(file);
		 byte[] contentInBytes = myContext.getBytes();
		 try {
			 FileOutputStream fop = new FileOutputStream(file,true);//使用FileoutputStream写入字节
	    if(!file.exists()) {
	    	file.createNewFile();
	    	 fop.write(contentInBytes);
			 fop.flush();
			 fop.close();
	    	//fw.write(myContext);
	    	//fw.close();
	    }else {
	    	 fop.write(contentInBytes);
			 fop.flush();
			 fop.close();
	    	//fw.append(myContext);
	    	//fw.close();
	    }
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
        //char[] aa=new char[1024];
        byte[] bb = new byte[1024];
        String str = "";// 用来将每次读取到的字符拼接，当然使用StringBuffer类更好  
        int n=0;// 每次读取到的字符长度  
        while ((n = fi.read(bb)) != -1) {  
            str += new String(bb, 0, n);  
        }  
        //reder.close();
        fi.close();
        System.out.println(str);  
	}
	@Override
	public void sendMSG(String textMsg) throws Exception {
		// TODO Auto-generated method stub
		  String userName = "";
		  String password = "";
		  String brokerURL = "tcp://127.0.0.1:61616";
		  ConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, brokerURL);;
	      Connection connection = factory.createConnection();;
	      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);;
		  Destination destination = session.createQueue("text-msg");
		  MessageProducer producer =  session.createProducer(destination);
		  TextMessage mytextMsg = session.createTextMessage(textMsg);
          producer.send(mytextMsg);
	}
	@Override
	public void recieveMSG() throws Exception {
		// TODO Auto-generated method stub		 
		 String userName = "";
		  String password = "";
		  String brokerURL = "tcp://127.0.0.1:61616";
		  ConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, brokerURL);;
	      Connection connection = factory.createConnection();;
	      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);;
		  Destination destination = session.createQueue("text-msg");
		  MessageConsumer consumer = session.createConsumer(destination);
		 /* while (true) {
	            TextMessage textMessage = (TextMessage) consumer.receive(100000);
	            if(textMessage != null){
	            	System.out.println(textMessage.getText());
	            }else {
	                break;
	            }
	        }	*/		
		   consumer.setMessageListener(new MessageListener() {
	            @Override
	            public void onMessage(Message message) {
	                try {
	                    //获取到接收的数据
	                    String text = ((TextMessage)message).getText();
	                    System.out.println(text+"ww");
	                } catch (JMSException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	}

}

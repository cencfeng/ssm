package com.cen.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cen.entity.File;

public interface Fileservice {

	public List<File> SaveFile(MultipartFile file,HttpServletRequest request) throws Exception;
	public void WrieToFile(String myContext) throws Exception;
	public void sendMSG(String textMsg) throws Exception;
	public void recieveMSG() throws Exception;
}

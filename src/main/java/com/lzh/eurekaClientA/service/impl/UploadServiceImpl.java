package com.lzh.eurekaClientA.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lzh.common.model.dto.fastdfs.FastDto;
import com.lzh.common.util.MD5Util;
import com.lzh.eurekaClientA.fastdfs.FastDFSClient;
import com.lzh.eurekaClientA.model.entity.TTestAudio;
import com.lzh.eurekaClientA.persistence.TTestAudioMapper;
import com.lzh.eurekaClientA.service.IUploadService;

import ch.qos.logback.classic.Logger;


@Service
public class UploadServiceImpl implements IUploadService {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(UploadServiceImpl.class);

	@Autowired
	private TTestAudioMapper ttestAudioMapper;

	@Override
	public TTestAudio saveFile(MultipartFile multipartFile) throws IOException {
		
		TTestAudio rs = new TTestAudio();
		
		String[] fileAbsolutePath={};
		//修改原名称，太长
//        String fileName=multipartFile.getOriginalFilename();
		String fileName=multipartFile.getOriginalFilename();
		String prefileName = MD5Util.MD5(fileName.substring(0,fileName.lastIndexOf(".")));
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        fileName = prefileName + "." + ext;
        byte[] file_buff = null;
        InputStream inputStream=multipartFile.getInputStream();
        if(inputStream!=null){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDto file = new FastDto(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
        	logger.error("upload file Exception!",e);
        }
        if (fileAbsolutePath==null) {
            logger.error("upload file failed,please upload again!");
        }
        
        String path=FastDFSClient.getTrackerUrl()+fileAbsolutePath[0]+ "/"+fileAbsolutePath[1];
        
        rs.setExtensionName(ext);
		rs.setSize(file_buff.length);
		rs.setName(fileName);
		rs.setUrl(path);
        
        return rs;
	}
	
}

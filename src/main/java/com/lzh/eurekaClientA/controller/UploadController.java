package com.lzh.eurekaClientA.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lzh.common.model.dto.fastdfs.FastDto;
import com.lzh.common.model.dto.response.ObjectDataResponse;
import com.lzh.eurekaClientA.model.entity.TTestAudio;
import com.lzh.eurekaClientA.service.IAudioService;

@RestController
@RequestMapping(value="/upload")
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

//    @Autowired
//    private IUploadService uploadService;
    
    @Autowired
    private IAudioService audioService;
    
    @PostMapping("/") 
    public ObjectDataResponse<String> singleFileUpload(@RequestParam("audioFile") MultipartFile audioFile,FastDto fastDto) {
    	
    	String rs = "";
        if (audioFile.isEmpty()) {
            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
        	rs ="Please select a file to upload";
        }
        
        try {
            // Get the file and save it somewhere
        	TTestAudio ta=audioService.uploadAndSaveAudio(audioFile,fastDto);
        	rs = ta.getUrl();
            System.out.println(rs);
        } catch (Exception e) {
            logger.error("upload file failed",e);
        }
        
        return new ObjectDataResponse<String>(rs);
    }

    /**
	 * 上传并添加一条音频
	 */
	@RequestMapping(value="/add" ,method=RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public ObjectDataResponse<String> addAudio(@RequestPart("audioFile") MultipartFile audioFile, FastDto fastDto){
		
		ObjectDataResponse<String> rs = new ObjectDataResponse<String>("");
		try {
			TTestAudio ta=audioService.uploadAndSaveAudio(audioFile,fastDto);
			rs.setData(ta.getUrl());
		} catch (IOException e) {
			rs.setData("上传保存失败");
			System.out.println("上传保存失败");
			e.printStackTrace();
		}
		 return rs;
	}
    
}
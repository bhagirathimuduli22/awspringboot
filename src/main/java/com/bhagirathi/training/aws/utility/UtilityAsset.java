package com.bhagirathi.training.aws.utility;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bhagirathi.training.aws.service.ServiceAWSS3;

@Component
public class UtilityAsset {
	
	@Autowired
	private ServiceAWSS3 serviceAWSS3;
	
	public String saveProfileImage(MultipartFile recording_multipart, Long id) {
		String fName = "";
		try {
			if (null != recording_multipart) {
				fName = "job_recording_" + id + "."
						+ FilenameUtils.getExtension(recording_multipart.getOriginalFilename());
				
				serviceAWSS3.uploadFile(recording_multipart, fName);
			}

		} catch (Exception e) {

		}
		return fName;
	}

}

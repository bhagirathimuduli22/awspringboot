package com.bhagirathi.training.aws.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class ServiceAWSS3 {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("${aws.s3.bucket}")
	private String bucketName;
	
	
	@Async
	public void uploadFile(final MultipartFile multipartFile, String fileName) {
		try {
			final File file = convertMultiPartFileToFile(multipartFile);
			uploadFileToS3Bucket(bucketName, file, fileName);
			file.delete(); // To remove the file locally created in the project folder.
		} catch (final AmazonServiceException ex) {

		}
	}
	
	
	private File convertMultiPartFileToFile(final MultipartFile multipartFile) {

		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (final IOException ex) {

		}
		return file;
	}
	
	private void uploadFileToS3Bucket(final String bucketName, final File file, final String fileName) {
		final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
		amazonS3.putObject(putObjectRequest);
	}

}

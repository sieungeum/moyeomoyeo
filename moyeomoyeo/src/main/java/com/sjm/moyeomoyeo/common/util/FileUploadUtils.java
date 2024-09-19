// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FileUploadUtils.java

package com.sjm.moyeomoyeo.common.util;

import com.sjm.moyeomoyeo.attach.dto.AttachDTO;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtils {
	
	@Value("#{util['file.upload.path']}")
	private String uploadPath; // appconfig.properties 에 적힌 file.upload.path 값 c:\\ upload 문자열이 필드변수 uploadPath 에 담김

	// MultipartFile 이 배열에 담겨서 오는 경우
	public List<AttachDTO> getAttachListByMultiparts(MultipartFile[] boFileArray) throws IOException {
		List<AttachDTO> attachList = new ArrayList<>();
		
		for (MultipartFile boFile : boFileArray) {
			if (!boFile.isEmpty()) {
				// 배열에 담긴 각 MultipartFile 에 대해 파일 저장
				AttachDTO attach = getAttachByMultipart(boFile);
				attachList.add(attach);
			}
		}

		return attachList;
	}

	public AttachDTO getAttachByMultipart(MultipartFile boFile) throws IOException {
		// uploadPath 에 저장될 파일명 생성 (유니크 아이디)
		String fileName = UUID.randomUUID().toString();
		
		// uploadPath 에 폴더 생성 (최초 한번만 실행)
		File uploadFolder = new File(uploadPath);
		uploadFolder.mkdir();
		
		// 파일 경로에 파일명 이어붙이기 (= 파일의 풀경로)
		// File.separatorChar 는 윈도우면 \\, 리눅스면 / 가 들어감
		String filePath = uploadPath + File.separatorChar + fileName;
		
		// 해당 경로에 실제로 파이 저장 (서버 PC의 로컬디스크)
		boFile.transferTo(new File(filePath));
		
		// 이후 DB에 담을 첨부파일 객체(AttachDTO) 생성 후 리턴 (mybatis에 넘겨줄 객체)
		AttachDTO attach = new AttachDTO();
		attach.setAtchFileName(fileName);
		attach.setAtchOrginName(boFile.getOriginalFilename());
		attach.setAtchFileSize(boFile.getSize());
		attach.setAtchFancySize(transferFancySize(boFile.getSize()));
		attach.setAtchContentType(boFile.getContentType());
		attach.setAtchPath(filePath);
		
		return attach;
	}

	// byte 단위 크기에 대해 적절히 KB, MB, GB 형태로 바꿔주는 메소드
	// 사용자에게 첨부된 파일의 크기를 화면에 보여줄 때 사용
	private String transferFancySize(long size) {
		DecimalFormat df = new DecimalFormat("#,###.0");
		
		// 파일의 크기가 1024 (1KB) 미만이라면 그냥 B를 붙여서 표기
		// 만약 1024 이상 1024* 1024(1MB) 미만이라면 B를 1024로 나눈 값을 KB 로 표기
		if (size < 1024) return size+"B";
		if (size < 1024 * 1024) return df.format(size / 1024.0)+"KB";
		if (size < 1024 * 1024 * 1024) return df.format(size / 1024.0 * 1024.0)+"MB";
		if (size < 1024 * 1024 * 1024 * 1024) return df.format(size / 1024.0 * 1024.0 * 1024.0)+"GB";
		
		return "large_file";
	}
}

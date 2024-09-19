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
	private String uploadPath; // appconfig.properties �� ���� file.upload.path �� c:\\ upload ���ڿ��� �ʵ庯�� uploadPath �� ���

	// MultipartFile �� �迭�� ��ܼ� ���� ���
	public List<AttachDTO> getAttachListByMultiparts(MultipartFile[] boFileArray) throws IOException {
		List<AttachDTO> attachList = new ArrayList<>();
		
		for (MultipartFile boFile : boFileArray) {
			if (!boFile.isEmpty()) {
				// �迭�� ��� �� MultipartFile �� ���� ���� ����
				AttachDTO attach = getAttachByMultipart(boFile);
				attachList.add(attach);
			}
		}

		return attachList;
	}

	public AttachDTO getAttachByMultipart(MultipartFile boFile) throws IOException {
		// uploadPath �� ����� ���ϸ� ���� (����ũ ���̵�)
		String fileName = UUID.randomUUID().toString();
		
		// uploadPath �� ���� ���� (���� �ѹ��� ����)
		File uploadFolder = new File(uploadPath);
		uploadFolder.mkdir();
		
		// ���� ��ο� ���ϸ� �̾���̱� (= ������ Ǯ���)
		// File.separatorChar �� ������� \\, �������� / �� ��
		String filePath = uploadPath + File.separatorChar + fileName;
		
		// �ش� ��ο� ������ ���� ���� (���� PC�� ���õ�ũ)
		boFile.transferTo(new File(filePath));
		
		// ���� DB�� ���� ÷������ ��ü(AttachDTO) ���� �� ���� (mybatis�� �Ѱ��� ��ü)
		AttachDTO attach = new AttachDTO();
		attach.setAtchFileName(fileName);
		attach.setAtchOrginName(boFile.getOriginalFilename());
		attach.setAtchFileSize(boFile.getSize());
		attach.setAtchFancySize(transferFancySize(boFile.getSize()));
		attach.setAtchContentType(boFile.getContentType());
		attach.setAtchPath(filePath);
		
		return attach;
	}

	// byte ���� ũ�⿡ ���� ������ KB, MB, GB ���·� �ٲ��ִ� �޼ҵ�
	// ����ڿ��� ÷�ε� ������ ũ�⸦ ȭ�鿡 ������ �� ���
	private String transferFancySize(long size) {
		DecimalFormat df = new DecimalFormat("#,###.0");
		
		// ������ ũ�Ⱑ 1024 (1KB) �̸��̶�� �׳� B�� �ٿ��� ǥ��
		// ���� 1024 �̻� 1024* 1024(1MB) �̸��̶�� B�� 1024�� ���� ���� KB �� ǥ��
		if (size < 1024) return size+"B";
		if (size < 1024 * 1024) return df.format(size / 1024.0)+"KB";
		if (size < 1024 * 1024 * 1024) return df.format(size / 1024.0 * 1024.0)+"MB";
		if (size < 1024 * 1024 * 1024 * 1024) return df.format(size / 1024.0 * 1024.0 * 1024.0)+"GB";
		
		return "large_file";
	}
}

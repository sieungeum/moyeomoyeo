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
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils
{

    public FileUploadUtils()
    {
    }

    public List getAttachListMultiparts(MultipartFile boFileArray[])
        throws IOException
    {
        List attachList = new ArrayList();
        MultipartFile amultipartfile[];
        int j = (amultipartfile = boFileArray).length;
        for(int i = 0; i < j; i++)
        {
            MultipartFile boFile = amultipartfile[i];
            if(!boFile.isEmpty())
            {
                AttachDTO attach = getAttachByMultipart(boFile);
                attachList.add(attach);
            }
        }

        return attachList;
    }

    public AttachDTO getAttachByMultipart(MultipartFile boFile)
        throws IOException
    {
        String fileName = UUID.randomUUID().toString();
        File uploadFolder = new File(uploadPath);
        uploadFolder.mkdir();
        String filePath = (new StringBuilder(String.valueOf(uploadPath))).append(File.separatorChar).append(fileName).toString();
        boFile.transferTo(new File(filePath));
        AttachDTO attach = new AttachDTO();
        attach.setAtchFileName(fileName);
        attach.setAtchOrginName(boFile.getOriginalFilename());
        attach.setAtchFileSize(boFile.getSize());
        attach.setAtchFancySize(transferFancySize(boFile.getSize()));
        attach.setAtchContetntType(boFile.getContentType());
        attach.setAtchPath(filePath);
        return attach;
    }

    private String transferFancySize(long size)
    {
        DecimalFormat df = new DecimalFormat("#,###.0");
        if(size < 1024L)
            return (new StringBuilder(String.valueOf(size))).append("B").toString();
        if(size < 0x100000L)
            return (new StringBuilder(String.valueOf(df.format((double)size / 1024D)))).append("KB").toString();
        if(size < 0x40000000L)
            return (new StringBuilder(String.valueOf(df.format((double)size / 1048576D)))).append("MB").toString();
        if(size < 0L)
            return (new StringBuilder(String.valueOf(df.format((double)size / 1073741824D)))).append("GB").toString();
        else
            return "\uD070 \uD30C\uC77C";
    }

    private String uploadPath;
}

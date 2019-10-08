package com.teaching.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

public interface QiNiuService {

    //上传文件
    Response uploadFile(File file) throws QiniuException;

    //上传文件
    Response uploadFile(InputStream inputStream, String fileName) throws QiniuException;

    //删除文件
    Response delete(String key) throws QiniuException;

}

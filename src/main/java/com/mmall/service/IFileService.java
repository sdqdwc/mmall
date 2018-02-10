package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author WangCH
 * @create 2018-02-09 20:44
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}

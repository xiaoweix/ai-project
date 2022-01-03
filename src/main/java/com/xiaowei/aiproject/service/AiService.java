package com.xiaowei.aiproject.service;

import org.springframework.web.multipart.MultipartFile;

public interface AiService {
    String picToWord(MultipartFile file);
}

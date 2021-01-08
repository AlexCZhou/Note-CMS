package com.typealpha.notecms.service;

import java.io.*;

public interface IFileService {

    /**
     * 读取整个文件并返回
     * @param filename 文件名
     * @return 整个文件内容
     */
    public String readFileToStr(String filename);
}

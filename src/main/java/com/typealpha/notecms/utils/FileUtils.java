package com.typealpha.notecms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {


    public static String readFileToStr(String filename) {
        String str;
        StringBuilder origin= new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            while ((str = in.readLine())!=null){
                origin.append(str).append("\n");
            }
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return origin.toString();
    }

    public static boolean createDirectory(String dirname){
        boolean result = false;
        File dir = new File(dirname);
        if(dir.exists()){
            System.out.println("已存在目录");
        }else{
            result = dir.mkdir();
        }
        return result;
    }

    public static boolean createFile(String filename){
        boolean result = false;
        File file = new File(filename);
        if(file.exists()){
            System.out.println("已存在文件");
        }
        else if(filename.endsWith(File.separator)){
            System.out.println("目标文件不能为目录");
        }
        else if(!file.getParentFile().exists()){
            System.out.println("目标文件目录不存在");
        }else {
            try {
                if (file.createNewFile()) {
                    result = true;
                } else {
                    System.out.println("创建文件失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

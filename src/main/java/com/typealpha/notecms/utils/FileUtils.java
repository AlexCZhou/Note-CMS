package com.typealpha.notecms.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtils {

    public static String readFileToStr(String filename) {
        String str;
        String origin="";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            while ((str = in.readLine())!=null){
                origin+=str+"\n";
            }
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return origin;
    }
}

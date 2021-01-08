package com.typealpha.notecms.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class FileServiceImpl implements IFileService {

    @Override
    public String readFileToStr(String filename) {
        String str;
        String origin="";
        try {
            //System.out.println(System.getProperty("user.dir"));

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

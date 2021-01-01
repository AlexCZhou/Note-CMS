package com.typealpha.notecms.service;

import com.typealpha.notecms.bean.Note;
import com.typealpha.notecms.dao.IGeneralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralServiceImpl implements IGeneralService {

    @Autowired
    IGeneralDao generalDao;

    private int parsePositiveInt(String s){
        int num;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 1; // 可能报错的page和asc的默认值都是1
        }
        return num;
    }

    @Override
    public List<Note> getNotes(int n, int option, int page, int asc) {
        return generalDao.getNotes(n,option,page,asc);
    }

    @Override
    public List<Note> getNotes(int n, int option, String page, String asc) {
        return getNotes(n,option,parsePositiveInt(page),parsePositiveInt(asc));
    }

    @Override
    public List<Note> getNotes(int n, int option, int page) {
        // 默认升序
        return getNotes(n,option,page,1);
    }

    @Override
    public List<Note> getNotes(int n, int option, String page) {
        return getNotes(n,option,parsePositiveInt(page));
    }

    @Override
    public List<Note> getNotes(int n, int option) {
        // 默认第一页升序
        return getNotes(n,option,1,1);
    }

    @Override
    public List<Note> getNotes(int n) {
        // 默认按更新时间第一页升序
        return getNotes(n,1,1,1);
    }
}

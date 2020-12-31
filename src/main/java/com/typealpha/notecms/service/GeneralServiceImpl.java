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
            return -1;
        }
        return num;
    }

    @Override
    public List<Note> getNotes(int n) {
        return generalDao.getNotes(n);
    }

    @Override
    public List<Note> getNotes(int n, int option) {
        return null;
    }
}

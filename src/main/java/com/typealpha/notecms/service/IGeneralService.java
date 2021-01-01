package com.typealpha.notecms.service;

import com.typealpha.notecms.bean.Note;

import java.util.List;

public interface IGeneralService {


    /**
     * 通过某种特定的方式获取n个文章的第page页
     * @param n 获取的文章个数
     * @param option 方式 - {1:更新时间新到旧，2:发布时间新到旧，3:标题字典序，4:作者昵称字典序，5:作者ID字典序}
     * @param page 包含n篇Note的Array List的第page页
     * @param asc 是否升序
     * @return
     */
    public List<Note> getNotes(int n, int option, int page, int asc);
    public List<Note> getNotes(int n, int option, String page, String asc);

    public List<Note> getNotes(int n, int option, int page);
    public List<Note> getNotes(int n, int option, String page);

    public List<Note> getNotes(int n, int option);

    public List<Note> getNotes(int n);



}

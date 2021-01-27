package com.typealpha.notecms.dao;

import com.typealpha.notecms.bean.Note;

import java.util.List;

public interface IGeneralDao {

    /**
     * 通过某种特定的方式获取n个文章的第page页
     * @param n 获取的文章个数
     * @param option 方式 - {1:更新时间新到旧，2:发布时间新到旧，3:标题字典序，4:作者ID字典序}
     * @param page 包含n篇Note的Array List的第page页
     * @param asc 是否升序
     * @return
     */
    public List<Note> getNotes(int n, int option, int page, int asc);

    /**
     * 获取全部的笔记个数
     * @return 笔记个数
     */
    public int getNoteCount();

    /**
     * 在数据库中创建一个notes
     *
     * 这里存在争抢同一篇文章ID的情况，先假设只有一个用户在使用web应用。
     *
     * @param noteHeading 文章的标题
     * @param currentUserID 当前用户的ID
     * @return 返回是否创建成功
     */
    public boolean createNote(String noteHeading, String currentUserID);

    /**
     * 获取某篇文章
     * @param noteID 文章id
     * @return 文章
     */
    public Note getNote(int noteID);
}

package com.typealpha.notecms.dao;

import com.typealpha.notecms.bean.Note;

import java.util.List;

public interface IGeneralDao {
    /**
     * 获取以更新时间最近的n个文章
     * @param n 获取的文章个数
     * @return 包含n篇Note的ArrayList
     */
    public List<Note> getNotes(int n);

    /**
     * 通过某种特定的方式获取n个文章
     * @param n 获取的文章个数
     * @param option 方式 - {1:更新时间新到旧，2:发布时间新到旧，3:标题字典序，4:作者昵称字典序，5:作者ID字典序}
     * @return 包含n篇Note的ArrayList
     */
    public List<Note> getNotes(int n, int option);
}

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

    /**
     * 获取总共多少页
     * @param n 每页的个数
     * @return 总共多少页的页数
     */
    public int getPageLength(int n);

    /**
     * 处理正整数，如果不是正整数返回一
     * @param s 输入字符串
     * @return 转换后的正整数或1
     */
    public int parsePositiveInt(String s);

    /**
     * 将Markdown转化为Html
     * @param origin Markdown格式文本
     * @return Html可以解析的文本
     */
    public String parseMarkdownToHtml(String origin);

    /**
     * 创建新的内容
     * @param heading 该内容的标题
     * @return 创建是否成功
     */
    public boolean createContent(String heading, String currentUserID);
}

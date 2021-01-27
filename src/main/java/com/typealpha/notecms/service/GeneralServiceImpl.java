package com.typealpha.notecms.service;

import com.typealpha.notecms.bean.Note;
import com.typealpha.notecms.dao.GeneralDaoImpl;
import com.typealpha.notecms.dao.IGeneralDao;
import com.typealpha.notecms.utils.FileUtils;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.nodes.NodeId;

import java.util.List;

@Service
public class GeneralServiceImpl implements IGeneralService {

    @Autowired
    IGeneralDao generalDao;

    public int parsePositiveInt(String s){
        int num;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 1; // 可能报错的page和asc的默认值都是1
        }
        if(num < 1){
            num = 1;
        }
        return num;
    }

    @Override
    public String parseMarkdownToHtml(String origin) {

        MutableDataSet option = new MutableDataSet();
        Parser parser = Parser.builder(option).build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        Node document = parser.parse(origin);
        return renderer.render(document);
    }

    @Override
    public boolean createContent(String heading,String currentUserID) {
        boolean result = false;
        //先在数据库执行创建操作，以便获取文件ID作为创建的文件名
        generalDao.createNote(heading,currentUserID);
        //获取最新的文章的ID
        //这里其实存在一个问题，多个用户同时创建文章时，可能出现编辑了其他人的文章的问题。
        Note note =  generalDao.getNotes(1,1,1,0).get(0);

        if(note!=null) {//需要进行没有文章的处理，显然没有文章的时候应该是逻辑出错误了
            int noteID = note.getId();
            System.out.println("noteID:"+noteID);
            //在static/note/中创建目录，以noteID命名，该文章的所有资源都将放置在此目录下
            String dirname = "src\\main\\resources\\static\\note\\%d";
            dirname = String.format(dirname, noteID);
            String filename = "src\\main\\resources\\static\\note\\%d\\main.md";
            if(FileUtils.createDirectory(dirname)){
                filename = String.format(filename,noteID);
                if(FileUtils.createFile(filename)){
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String readFileToStr(String filename) {
        return FileUtils.readFileToStr(filename);
    }

    @Override
    public Note getNote(String noteID) {
        int id = parsePositiveInt(noteID);
        return generalDao.getNote(id);
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

    @Override
    public int getPageLength(int n) {
        return generalDao.getNoteCount()/n + 1;
    }
}

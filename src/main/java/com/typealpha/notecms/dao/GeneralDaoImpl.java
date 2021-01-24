package com.typealpha.notecms.dao;

import com.typealpha.notecms.bean.Note;
import com.typealpha.notecms.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GeneralDaoImpl implements IGeneralDao {

    @Override
    public List<Note> getNotes(int n, int option, int page, int asc) {
        Connection connection = DBUtils.getConn();
        ResultSet reSet;
        List<Note> notes= new ArrayList<>();
        String sql = "SELECT * FROM cms_notes ORDER BY %s %s limit ?,?";
        String op = "note_latest_update";
        String order = "asc";
        //判断排序方法
        switch (option){
            case 1: op = "note_latest_update";
            break;
            case 2: op = "note_publish_time";
            break;
            case 3: op = "note_heading";
            break;
            case 4: op = "note_owner";
            break;
        }
        if(asc==0){
            order = "desc";
        }
        sql = String.format(sql,op,order);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,page*n-n);
            preparedStatement.setInt(2,n);
            reSet = preparedStatement.executeQuery();

            while (reSet.next()){
                Note note = new Note();
                note.setId(reSet.getInt(1));
                note.setHeading(reSet.getString(2));
                note.setPublishTime(reSet.getTimestamp(3));
                note.setLatestUpdate(reSet.getTimestamp(4));
                note.setOwner(reSet.getString(5));
                note.setRestrict(reSet.getInt(6));
                note.setStatus(reSet.getInt(7));
                notes.add(note);
            }

            connection.close();
            reSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }

    @Override
    public int getNoteCount() {
        Connection connection = DBUtils.getConn();
        ResultSet reSet;
        int count=-1;
        String sql = "SELECT count(*) FROM cms_notes;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            reSet = preparedStatement.executeQuery();

            while (reSet.next()){
                count = reSet.getInt(1);
            }

            reSet.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean createNote(String noteHeading,String currentUserID) {
        boolean result = false;
        Connection connection = DBUtils.getConn();
        ResultSet reSet;
        String sql = "INSERT INTO " +
                "cms_notes(note_heading,note_publish_time,note_latest_update,note_owner,note_restrict,note_status) " +
                "values(?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?,3,1)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,noteHeading);
            preparedStatement.setString(2,currentUserID);
            int row = preparedStatement.executeUpdate();
            if(row!=0){
                result = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}

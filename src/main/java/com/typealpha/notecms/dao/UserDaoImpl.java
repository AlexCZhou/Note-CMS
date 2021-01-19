package com.typealpha.notecms.dao;

import com.typealpha.notecms.bean.User;
import com.typealpha.notecms.utils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public boolean verifyLoin(String username, String password) {
        return verify(username, password, "SELECT user_password FROM cms_users where user_id = ?");
    }

    @Override
    public boolean verifyCookie(String username, String cookie) {
        return verify(username, cookie, "SELECT user_cookie FROM cms_users where user_id = ?");
    }

    private boolean verify(String username, String origin, String s) {
        boolean result = false;
        Connection connection = DBUtils.getConn();
        ResultSet reSet;
        String recordedCookie = null;
        String sql = s;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            reSet = preparedStatement.executeQuery();
            boolean found = false;
            while (reSet.next()){
                found = true;
                recordedCookie = reSet.getString(1);
            }
            if(found && recordedCookie.equals(origin)){
                result = true;
            }
            reSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean setCookie(String username, String cookie) {
        boolean result = false;
        Connection connection = DBUtils.getConn();
        String sql = "UPDATE cms_users SET user_cookie = ? where user_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cookie);
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
            connection.close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getCurrentUser(String username) {
        Connection connection = DBUtils.getConn();
        ResultSet reSet;
        User result = null;
        String sql = "SELECT user_nickname,user_bio,user_authority FROM cms_users WHERE user_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            reSet = preparedStatement.executeQuery();
            boolean found = false;
            while (reSet.next()){
                found = true;
                result = new User();
                result.setId(username);
                result.setNickname(reSet.getString(1));
                result.setBio(reSet.getString(2));
                result.setAuthority(reSet.getInt(3));
            }
            if(!found){
                //这一步是为了防止没有找到用户名，用户可能自己搞了个cookie
                result.setId("Guest");
                result.setAuthority(0);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}

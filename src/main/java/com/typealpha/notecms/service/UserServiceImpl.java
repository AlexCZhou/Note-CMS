package com.typealpha.notecms.service;

import com.typealpha.notecms.bean.User;
import com.typealpha.notecms.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.SHA;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public boolean verifyLoin(String username, String password) {
        return userDao.verifyLoin(username,SHA1Encryption(password));
    }

    @Override
    public boolean verifyCookie(String username, String cookie) {
        boolean result = false;
        //游客账户不需要再调用dao层验证了
        if(!"Guest".equals(username) && !"Guest".equals(cookie)){
            result = userDao.verifyCookie(username,cookie);
        }
        return result;
    }

    @Override
    public String generateCookie(String username, String password) {
        //混肴用，毕竟是开源的
        String currentTime = Long.toString(System.currentTimeMillis());
        String magicNum="211701148";
        String cookieValue =  username + password + currentTime + magicNum;
        System.out.println("Origin cookie value: "+cookieValue);
        cookieValue = SHA1Encryption(cookieValue);
        userDao.setCookie(username, cookieValue);
        return cookieValue;
    }

    @Override
    public User getCurrentUser(String username) {
        User result;
        if("Guest".equals(username)){
            User guest = new User();
            guest.setAuthority(0);
            guest.setId("Guest");
            result = guest;
        }else{
            result = userDao.getCurrentUser(username);
        }
        return result;
    }


    private String SHA1Encryption(String origin){
        String result=null;
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA-1");
            md.reset();
            md.update(origin.getBytes("UTF-8"));
            result  = byteToHex(md.digest());
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 用于把SHA-1加密后的16进制结果转换为字符串
     * @param hash 16进制加密结果
     * @return SHA-1加密字符串
     */
    String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}

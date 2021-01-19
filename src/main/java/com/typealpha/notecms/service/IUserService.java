package com.typealpha.notecms.service;

import com.typealpha.notecms.bean.User;

public interface IUserService {
    /**
     * 检查登录是否正确
     * @param username 用户名
     * @param password 密码
     * @return 是否正确
     */
    public boolean verifyLoin(String username,String password);

    /**
     * 检查cookie是否匹配
     * @param username 用户名
     * @param cookie cookie
     * @return 是否匹配
     */
    public boolean verifyCookie(String username,String cookie);

    /**
     * 生成cookie并保存到数据库中，返回生成的cookie
     * @param username 用户名
     * @param password 密码
     * @return cookie
     */
    public String generateCookie(String username,String password);

    /**
     * 返回当前登录的User，如果当前未登录则返回游客账号。
     * *请注意使用这个方法之前先验证登录状态！
     * 出于安全考虑，密码和Cookie不会被保存在返回的类中
     * @param username 用户名
     * @return 当前User的Pojo类
     */
    public User getCurrentUser(String username);

}


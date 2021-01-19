package com.typealpha.notecms.dao;

import com.typealpha.notecms.bean.User;

public interface IUserDao {
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
     * 设置cookie
     * @param username 要设置的用户名
     * @param cookie 要设置的cookie
     * @return 是否添加成功
     */
    public boolean setCookie(String username,String cookie);

    /**
     * 根据用户名返回用户的信息
     *
     * 出于安全考虑，密码和Cookie不会被保存在返回的类中
     * @param username 用户名
     * @return 当前User的Pojo类
     */
    public User getCurrentUser(String username);

}

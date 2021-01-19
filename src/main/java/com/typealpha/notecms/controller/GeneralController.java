package com.typealpha.notecms.controller;

import com.typealpha.notecms.service.IFileService;
import com.typealpha.notecms.service.IGeneralService;

import com.typealpha.notecms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class GeneralController {

    @Autowired
    IGeneralService generalService;
    @Autowired
    IFileService fileService;
    @Autowired
    IUserService userService;

    @RequestMapping(value = {
            "",
            "/index",
            "/index.html"
    })
    public ModelAndView getIndexPage(@CookieValue(value = "user_id",defaultValue = "Guest") String user_id,
                                     @CookieValue(value = "user_status",defaultValue = "Guest") String user_status){
        ModelAndView mav = new ModelAndView();
        mav.addObject("authority",checkLoginStatus(user_id,user_status));
        mav.addObject("notes",generalService.getNotes(10));//获取最近十篇笔记并渲染
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/allposts")
    public ModelAndView getAllPostsPage(@CookieValue(value = "user_id",defaultValue = "Guest") String user_id,
                                        @CookieValue(value = "user_status",defaultValue = "Guest") String user_status,
                                        @RequestParam(required = false) String page){
        ModelAndView mav = new ModelAndView();
        if(page==null){//默认访问是没有page参数的
            mav.addObject("notes",generalService.getNotes(10,1));
            mav.addObject("currentPage",1);
        }else {
            mav.addObject("notes", generalService.getNotes(10, 1, page));
            mav.addObject("currentPage",generalService.parsePositiveInt(page));
        }
        mav.addObject("pageLength",generalService.getPageLength(10));
        mav.addObject("authority",checkLoginStatus(user_id,user_status));
        mav.setViewName("allposts");
        return mav;
    }

    @RequestMapping("/content/note/{noteID}")
    public ModelAndView getNotePage(@CookieValue(value = "user_id",defaultValue = "Guest") String user_id,
                                    @CookieValue(value = "user_status",defaultValue = "Guest") String user_status,
                                    @PathVariable String noteID){
        ModelAndView mav = new ModelAndView();

        String filename = "src\\main\\resources\\static\\note\\%s\\main.md"; //这东西编译以后咋办呀。。。
        filename = String.format(filename,noteID);

        mav.addObject("contents",generalService.parseMarkdownToHtml(fileService.readFileToStr(filename)));

        mav.addObject("authority",checkLoginStatus(user_id,user_status));
        mav.setViewName("note");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView getLoginPage(@CookieValue(value = "user_id",defaultValue = "Guest") String user_id,
                                     @CookieValue(value = "user_status",defaultValue = "Guest") String user_status,
                                     HttpServletRequest request, HttpServletResponse response){
        //已经登录的用户不要再重复登录了
        System.out.println(user_id);
        System.out.println(user_status);
        if(checkLoginStatus(user_id,user_status)!=0){
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("authority",checkLoginStatus(user_id,user_status));
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("/loginCheck")
    public void CheckLogin(@CookieValue(value = "user_id",defaultValue = "Guest") String user_id,
                                   @CookieValue(value = "user_status",defaultValue = "Guest") String user_status,
                                   @RequestParam String username, @RequestParam String password,
                                   HttpServletRequest request, HttpServletResponse response){

        //已经登录的用户不要再重复登录了
        if(checkLoginStatus(user_id,user_status)!=0){
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(userService.verifyLoin(username, password)){
            Cookie userCookie = new Cookie("user_id",username);
            userCookie.setMaxAge(60*60*24);
            userCookie.setPath("/");
            Cookie userStatus = new Cookie("user_status",userService.generateCookie(username,password));
            userStatus.setMaxAge(60*60*24);
            userStatus.setPath("/");
            response.addCookie(userCookie);
            response.addCookie(userStatus);
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                response.sendRedirect("/login?err=E000");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/test")
    public ModelAndView test(@CookieValue(value = "user_id",defaultValue = "Guest") String user_id,
                             @CookieValue(value = "user_status",defaultValue = "Guest") String user_status){
        ModelAndView mav = new ModelAndView();

        System.out.println(user_id);
        System.out.println(user_status);

        mav.addObject("notes",generalService.getNotes(10));//获取最近十篇笔记并渲染
        mav.setViewName("index");
        return mav;
    }

    /**
     * 验证cookie，返回登录状态
     * 0:游客
     * 1:普通用户
     * 2:管理员
     * 3:超级管理员
     * @param user_id cookie: user_id
     * @param user_status cookie: user_status
     * @return 整型，表示用户的权限。
     */
    private int checkLoginStatus(String user_id, String user_status){
        int result = 0;
        //先检验是否是记录的cookie，防止用户自己设置cookie绕过验证
        if(userService.verifyCookie(user_id,user_status)){
            result = userService.getCurrentUser(user_id).getAuthority();

        }
        return result;
    }


    private void authorityCheck(int currentAuthority, int authorityRequired, String redirectTo,HttpServletResponse response){
        if(currentAuthority < authorityRequired){
            try {
                response.sendRedirect(redirectTo);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }




}

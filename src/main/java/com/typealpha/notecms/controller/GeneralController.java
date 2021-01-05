package com.typealpha.notecms.controller;

import com.typealpha.notecms.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GeneralController {

    @Autowired
    IGeneralService generalService;

    @RequestMapping(value = {
            "",
            "/index",
            "/index.html"
    })
    public ModelAndView getIndexPage(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("notes",generalService.getNotes(10));//获取最近十篇笔记并渲染
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("allposts")
    public ModelAndView getAllPostsPage(@RequestParam(required = false) String page){
        ModelAndView mav = new ModelAndView();
        //获取当前页数的十个
        if(page==null){
            mav.addObject("notes",generalService.getNotes(10,1));
            mav.addObject("currentPage",1);
        }else {
            mav.addObject("notes", generalService.getNotes(10, 1, page));
            mav.addObject("currentPage",generalService.parsePositiveInt(page));
        }
        //获取总共多少页
        mav.addObject("pageLength",generalService.getPageLength(10));
        //标记当前页


        mav.setViewName("allposts");
        return mav;
    }

    @RequestMapping("login")
    public ModelAndView getLoginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}

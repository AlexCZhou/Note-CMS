package com.typealpha.notecms.controller;

import com.typealpha.notecms.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
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
        mav.addObject("Notes",generalService.getNotes(10));//获取最近十篇笔记并渲染
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("login")
    public ModelAndView getLoginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}

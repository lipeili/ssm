package com.lagou.edu.controller;

import com.lagou.edu.pojo.Account;
import com.lagou.edu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * Spring容器和SpringMVC容器是有层次的（父子容器）
     * Spring容器：service对象+dao对象
     * SpringMVC容器：controller对象，，，，可以引用到Spring容器中的对象
     */
    @Autowired
    private AccountService accountService;

    private final String LOGIN_CHECK_ERROR = "用户名密码错误";


    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request,ModelAndView modelAndView) throws Exception {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        if ("admin".equals(name) && "admin".equals(passwd)) {
            modelAndView = accountService.refresh(modelAndView);
            request.getSession().setAttribute("isAuth","1");
        } else {
            modelAndView.addObject("msg", LOGIN_CHECK_ERROR);
            modelAndView.setViewName("index");
        }

        return modelAndView;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public ModelAndView queryAll(ModelAndView modelAndView) throws Exception {
        return accountService.refresh(modelAndView);
    }

    @RequestMapping("/queryDetail")
    @ResponseBody
    public Account queryDetail(String name) throws Exception {
        return accountService.queryAccountList().stream().filter(e -> name.equals(e.getName())).collect(Collectors.toList()).get(0);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ModelAndView add(ModelAndView modelAndView, Account account) throws Exception {
        accountService.save(account);
        return accountService.refresh(modelAndView);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ModelAndView update(ModelAndView modelAndView, Account account) throws Exception {
        accountService.update(account);
        return accountService.refresh(modelAndView);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ModelAndView delete(ModelAndView modelAndView, String name) throws Exception {
        accountService.delete(name);
        return accountService.refresh(modelAndView);
    }

}

package com.lagou.edu.service;

import com.lagou.edu.pojo.Account;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface AccountService {

    List<Account> queryAccountList() throws Exception;

    int save(Account account) throws Exception;

    int update(Account account) throws Exception;

    int delete(String name) throws Exception;

    ModelAndView refresh (ModelAndView modelAndView) throws Exception;

}

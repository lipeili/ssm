package com.lagou.edu.service.impl;

import com.lagou.edu.mapper.AccountMapper;
import com.lagou.edu.pojo.Account;
import com.lagou.edu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> queryAccountList() throws Exception {
        return accountMapper.queryAccountList();
    }

    @Override
    public int save(Account account) throws Exception {
        return accountMapper.insert(account);
    }

    @Override
    public int update(Account account) throws Exception {
        return accountMapper.update(account);
    }

    @Override
    public int delete(String name) throws Exception {
        return accountMapper.delete(name);
    }

    public ModelAndView refresh (ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("success");
        modelAndView.addObject("accounts", queryAccountList());
        return modelAndView;
    }
}

package com.example.elasticsearch.service.serviceImpl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.elasticsearch.bean.Account;
import com.example.elasticsearch.bean.Personal;
import com.example.elasticsearch.mapper.AccountMapper;
import com.example.elasticsearch.mapper.PersonalMapper;
import com.example.elasticsearch.service.AccountService;
import com.example.elasticsearch.service.DSOneService;
import com.example.elasticsearch.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DSOneServiceImpl implements DSOneService {

    @Resource
    private PersonalMapper personalMapper;

    @Resource
    private AccountMapper accountMapper;

    @Override
    @DS("slave_1")
    public void oneTest() {
        List<Personal> personals = personalMapper.oneTest();
        System.out.println(personals);
    }

    @Override
    public void twoTest(Integer id) {
        Account account = accountMapper.twoTest(id);
        System.out.println(account);
    }

    @Override
    @DS("slave_2")
    public void threeTest(Integer id) {
        Account account = accountMapper.twoTest(id);
        System.out.println(account);
    }

    @Override
    public void fourTest() {

    }
}

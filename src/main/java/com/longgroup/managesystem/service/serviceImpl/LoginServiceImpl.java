package com.longgroup.managesystem.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longgroup.managesystem.domain.Users;
import com.longgroup.managesystem.mapper.LoginMapper;
import com.longgroup.managesystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Users login(String username, String password) {
        //查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        queryWrapper.eq("status", 1);
//        List<Users> list = loginMapper.selectList(queryWrapper);
        Users users = loginMapper.selectOne(queryWrapper);
        return users;
    }

    @Override
    public Users findUserById(String userid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid", userid);
        Users users = loginMapper.selectOne(queryWrapper);
        return users;
    }
}

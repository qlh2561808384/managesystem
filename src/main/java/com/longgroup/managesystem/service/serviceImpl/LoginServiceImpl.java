package com.longgroup.managesystem.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.longgroup.managesystem.domain.Users;
import com.longgroup.managesystem.mapper.LoginMapper;
import com.longgroup.managesystem.service.LoginService;
import com.longgroup.managesystem.utils.dateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        queryWrapper.eq("status", 0);
//        List<Users> list = loginMapper.selectList(queryWrapper);
        Users users = loginMapper.selectOne(queryWrapper);
        return users;
    }

    @Override
    public void register(String name, String password, String time) {
        Users users = new Users();
        users.setUsername(name);
        users.setPassword(password);
        users.setCreatetime(dateUtil.get24HCurrentTime_Calendar("ymdhms"));
        loginMapper.insert(users);
    }

    @Override
    public Users checkUsername(String name) {
        //查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", name);
        queryWrapper.eq("status", 0);
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

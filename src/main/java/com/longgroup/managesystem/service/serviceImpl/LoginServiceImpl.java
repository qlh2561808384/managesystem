package com.longgroup.managesystem.service.serviceImpl;

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
    public List login(String username, String password) {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        //新增
        int insert = loginMapper.insert(users);
        //查询
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password",password);
        List<Users> users1 = loginMapper.selectByMap(map);
        return users1;
    }
}

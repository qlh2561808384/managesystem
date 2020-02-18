package com.longgroup.managesystem.service;

import com.longgroup.managesystem.domain.Users;

import java.util.List;

public interface LoginService {
//    int login(String username,String password);
    Users login(String username, String password);

    void register(String name,String password,String time);

    Users checkUsername(String name);

    Users findUserById(String userid);
}

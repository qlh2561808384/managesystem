package com.longgroup.managesystem.service;

import com.longgroup.managesystem.domain.Users;

import java.util.List;

public interface LoginService {
//    int login(String username,String password);
List<Users> login(String username, String password);

    Users findUserById(String userid);
}

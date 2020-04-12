package com.longgroup.managesystem.service;


public interface UploadService {
    void saveImg(String username, String path);

    String[] getImgPath(String username);
}

package com.longgroup.managesystem.utils;

import java.io.File;

public class UploadUtils {

    public static File getImgDirFile(String uploadPath,String username) {
        String ImgPath = new String(uploadPath + File.separator + username);
        File fileDir = new File(ImgPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}

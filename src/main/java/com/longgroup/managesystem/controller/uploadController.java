package com.longgroup.managesystem.controller;

import com.longgroup.managesystem.domain.Upload;
import com.longgroup.managesystem.service.UploadService;
import com.longgroup.managesystem.utils.Result;
import com.longgroup.managesystem.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("upload")
public class uploadController {
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private UploadService uploadService;

    @RequestMapping("/uploadImg")
    public Result uploadImg(HttpServletRequest request, String username) {
        Result msg = new Result();
        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        for (MultipartFile file : files.values()) {
            long ymrhms = System.currentTimeMillis();
            if (file.isEmpty()) {
                // 设置错误状态码
                msg.setSuccess(false);
                msg.setContent("上传失败，请选择文件");
                return msg;
            }
            // 拿到文件名
            String newName = null;
            String filename = file.getOriginalFilename();
//            String[] split = filename.split("\\.");
            int one = filename.lastIndexOf(".");
            if (-1 == one) {
                msg.setSuccess(false);
                msg.setContent("上传失败,上传文件格式不对");
                return msg;
            }else {
                newName = filename.replace(filename.substring(0, one), String.valueOf(ymrhms));
            }

            // 存放上传图片的文件夹
            File imgFileDir = UploadUtils.getImgDirFile(uploadPath,username);
            // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
//            System.out.println(fileDir.getAbsolutePath());
            try {
                // 构建真实的文件路径
                File newFile = new File(imgFileDir.getAbsolutePath() + File.separator + newName);
//                System.out.println(newFile.getAbsolutePath());

                //保存照片信息到数据库

                uploadService.saveImg(username, imgFileDir.getAbsolutePath() + File.separator + newName);
                // 上传图片到 -》 “绝对路径”
                file.transferTo(newFile);
                msg.setSuccess(true);
                msg.setContent(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

    @RequestMapping("getImgPath")
    public String[] getImgPath(String name) {
        String[] imgPath = uploadService.getImgPath(name);
        return imgPath;
    }
}

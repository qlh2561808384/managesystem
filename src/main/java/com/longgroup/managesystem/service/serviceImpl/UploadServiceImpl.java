package com.longgroup.managesystem.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.longgroup.managesystem.domain.Upload;
import com.longgroup.managesystem.mapper.UploadMapper;
import com.longgroup.managesystem.service.UploadService;
import com.longgroup.managesystem.utils.dateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;

    @Override
    public void saveImg(String username, String path) {
        Upload upload = new Upload();
        upload.setUptime(dateUtil.get24HCurrentTime_Calendar("ymdhms"));
        upload.setUpuser(username);
        upload.setImgpath(path);
        uploadMapper.insert(upload);
    }

    @Override
    public String[] getImgPath(String username) {
        QueryWrapper<Upload> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("upuser",username);
        List<Upload> uploads = uploadMapper.selectList(queryWrapper);
        String[] arr = new String[uploads.size()];
        for (int i = 0; i < uploads.size(); i++) {
            String imgPath = uploads.get(i).getImgpath();
            String substring = imgPath.substring(imgPath.lastIndexOf(File.separator)).substring(1);
            arr[i] = substring;
        }
        return arr;
    }
}

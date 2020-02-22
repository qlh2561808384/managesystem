package com.longgroup.managesystem.service.serviceImpl;

import com.longgroup.managesystem.mapper.UploadMapper;
import com.longgroup.managesystem.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;
}

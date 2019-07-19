package demo.business.service.info.impl;

import demo.business.service.info.CustomerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.business.mapper.info.CustomerInfoMapper;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService
{
    @Autowired
    private CustomerInfoMapper mapper;
}
package demo.business.service.busi.impl;

import demo.business.service.busi.CustomerBusiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.business.mapper.busi.CustomerBusiMapper;

@Service
public class CustomerBusiServiceImpl implements CustomerBusiService
{
    @Autowired
    private CustomerBusiMapper mapper;
}
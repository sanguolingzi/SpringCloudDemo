package demo.business.service.busi.impl;

import demo.business.service.busi.OrderBusiService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import demo.business.mapper.busi.OrderBusiMapper;

@Service
public class OrderBusiServiceImpl implements OrderBusiService
{
    @Autowired
    private OrderBusiMapper orderBusiMapper;
}
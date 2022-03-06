package com.tbd.service.impl;

import com.tbd.dao.OrderDao;
import com.tbd.domain.Order;
import com.tbd.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;


    @Override
    public List<Order> queryAllOrder() {
        return orderDao.template(new Order().setTableId(1L));
    }

    @Override
    public boolean createOrder() {
        return false;
    }
}

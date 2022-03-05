package com.tbd.service.impl;

import com.tbd.domain.Order;
import com.tbd.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> queryAllOrder() {
        return null;
    }
}

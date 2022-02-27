package com.tbd.service;

import com.tbd.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public List<Order> queryAllOrder();
}

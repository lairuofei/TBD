package com.tbd.service;

import com.tbd.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public List<Order> queryAllOrder(int i);
}

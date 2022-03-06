package com.tbd.dao;

import com.tbd.domain.Order;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author lairuofei
 */
@Repository
public interface OrderDao extends BaseMapper<Order> {
}

package com.tbd.dao;

import com.tbd.domain.Item;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author lairuofei
 */
@Repository
public interface ItemDao extends BaseMapper<Item> {
}

package com.tbd.dao;

import com.tbd.domain.TestTable;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTableDao extends BaseMapper<TestTable> {
}

package com.tbd;

import com.tbd.dao.TestTableDao;
import com.tbd.domain.TestTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbdApplicationTests implements Serializable {


    @Autowired
    TestTableDao testTableDao;

    @Test
    @Transactional
    public void contextLoads() {
        testTableDao.insert(new TestTable()
                .setId(1L)
                .setName("ruofei"));
    }

}

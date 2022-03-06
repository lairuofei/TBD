package com.tbd;

import cn.hutool.core.thread.ExecutorBuilder;
import com.tbd.dao.TestTableDao;
import com.tbd.domain.TestTable;
import com.tbd.service.OrderService;
import lombok.Getter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbdApplicationTests implements Serializable {


    @Autowired
    TestTableDao testTableDao;

    @Autowired
    OrderService orderService;

    @Getter
    ThreadPoolExecutor executor = ExecutorBuilder.create()
            .setCorePoolSize(50)
            .setMaxPoolSize(50)
            .useSynchronousQueue()
            .setHandler(new ThreadPoolExecutor.DiscardPolicy())
            .build();

    @Test
    @Transactional
    public void contextLoads() {
        testTableDao.insert(new TestTable()
                .setId(1L)
                .setName("ruofei"));
    }

    @Test
    public void testConcurrent(){
        for (int i = 0; i < 20000; i++) {
            int finalI = i;
            executor.submit(()->{
                orderService.queryAllOrder(finalI);
            });
        }
    }

}

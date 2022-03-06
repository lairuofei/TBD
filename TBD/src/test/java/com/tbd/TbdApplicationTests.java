package com.tbd;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.util.IdUtil;
import com.tbd.dao.OrderDao;
import com.tbd.dao.TestTableDao;
import com.tbd.domain.Order;
import com.tbd.domain.TestTable;
import com.tbd.service.OrderService;
import lombok.Getter;
import org.beetl.sql.core.db.KeyHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.*;

import static org.springframework.test.context.transaction.TestTransaction.start;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbdApplicationTests implements Serializable {


    @Autowired
    TestTableDao testTableDao;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao orderDao;

    @Autowired
    @Qualifier("testExecutor")
    ThreadPoolExecutor executor;

    @Test
//    @Transactional
    public void contextLoads() {
        testTableDao.insert(new TestTable()
                .setId(1L)
                .setName("ffff"));
    }

    @Test
    public void testConcurrent() throws InterruptedException {
        for (int i = 0; i < 20000; i++) {
            executor.submit(() -> {
                orderService.queryAllOrder();
            });
        }
        executor.shutdown();
        try {
            boolean loop = true;
            do {
                loop = !executor.awaitTermination(2, TimeUnit.SECONDS);
            } while(loop);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setTableId(2l);
        order.setOrderNo(IdUtil.randomUUID());
//        System.out.println(order.getOrderId());
        orderDao.insert(order);
    }

    @Test
    public void findOrder(){
        List<Order> template = orderDao.template(new Order().setTableId(2L));
        System.out.println(template);
    }
}

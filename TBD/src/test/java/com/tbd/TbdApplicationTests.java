package com.tbd;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.tbd.dao.ItemDao;
import com.tbd.dao.OrderDao;
import com.tbd.dao.TestTableDao;
import com.tbd.domain.Item;
import com.tbd.domain.Order;
import com.tbd.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.*;

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
    ItemDao itemDao;

    @Autowired
    @Qualifier("testExecutor")
    ThreadPoolExecutor executor;

    @Test
//    @Transactional
    public void contextLoads() {
        System.out.println(DateUtil.date());
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
        Order order = new Order().setTableId(2l)
                                 .setOrderNo(IdUtil.randomUUID());
        orderDao.insert(order);
    }

    @Test
    public void findOrder(){
        List<Order> template = orderDao.template(new Order().setTableId(2L));
        System.out.println(template);
    }

    @Test
    public void insertItem(){
        Item item = (Item) new Item().setItemId(IdUtil.randomUUID()).setCreatedAt(DateUtil.date());
        itemDao.insert(item);
    }

    @Test
    public void getItem(){
        System.out.println(itemDao.templateOne(new Item().setAutoId(15L)).getCreatedAt());
    }
}

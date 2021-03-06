package com.tbd.common;

import cn.hutool.core.thread.ExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolUtils {

    @Bean("testExecutor")
    public ThreadPoolExecutor threadPoolExecutor(){
        ThreadPoolExecutor executor = ExecutorBuilder.create()
                .setCorePoolSize(500)
                .setMaxPoolSize(500)
                .useSynchronousQueue()
                .setHandler(new ThreadPoolExecutor.DiscardPolicy())
                .build();
        return executor;
    }
}

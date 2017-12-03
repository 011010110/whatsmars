package com.whatsmars.dubbo.demo.consumer;

import com.whatsmars.dubbo.demo.consumer.rpc.DemoRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by javahongxi on 2017/12/4.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        DemoRpc demoRpc = context.getBean(DemoRpc.class);
        System.out.println(demoRpc.sayHello("Lily"));
    }
}

package com.itlong.whatsmars.spring;

import com.itlong.whatsmars.spring.model.Mars;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shenhongxi on 2016/7/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test.xml")
public class XxDemo {
    @Autowired
    private Mars mars;

    @Test
    public void hi() {
        System.out.println(mars.getAge());
    }
}

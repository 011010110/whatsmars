package com.itlong.whatsmars.spring.boot;

import com.itlong.whatsmars.spring.boot.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// 加上exclude=DataSource..后，不会连接数据库，同时@Mapper也不会起作用
@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({UserConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
package org.hongxi.whatsmars.cloud.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shenhongxi on 2017/9/14.
 */
@FeignClient(value = "demo-provider", fallback = DemoHystrix.class)
public interface DemoFeign {
    @RequestMapping("/hello")
    String hello(@RequestParam(name = "name") String name); // 此处必须有RequestParam
}

package com.akikun.demo.spring.job;

/**
 * @author 李俊秋(龙泽)
 */

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author 李俊秋(龙泽)
 */
@RestController
@RequestMapping("/job/test")
public class JobController {

    @PostMapping("/create")
    public void create(@RequestBody Order order) {
        Optional<String> orderName = Optional.ofNullable(order).map(Order::getName);
        orderName.ifPresent(Order.order::setName);
    }

}

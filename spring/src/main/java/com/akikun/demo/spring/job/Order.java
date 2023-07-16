package com.akikun.demo.spring.job;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 李俊秋(龙泽)
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 3909668365421268039L;

    public static final Order order = new Order();



    private String name;

}

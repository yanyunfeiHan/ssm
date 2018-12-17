package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;

/**
 * 一对多：一个客户对应多个订单
 * 多对一：多个订单对应一个客户(一个订单对应一个客户)
 */
@ToString
public class Order  implements Serializable{
    private Integer orderId;

    private String orderNo;

    private Integer cid;

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(Integer orderId, String orderNo, Integer cid) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.cid = cid;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
package com.zking.ssm.service.imp;

import com.zking.ssm.model.Order;
import com.zking.ssm.service.IOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderServiceImplTest extends BaseTestCase {

    @Autowired
    private IOrderService orderService;

    @Test
    public void querySingleOrder() {
        Order order =
                orderService.querySingleOrder(11);
        System.out.println(order);
    }
}
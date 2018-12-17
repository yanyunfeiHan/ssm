package com.zking.ssm.service.imp;

import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerSevice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerSeviceImplTest extends BaseTestCase {

    @Autowired
    private ICustomerSevice customerSevice;

    @Test
    public void queryCustomerLst() {
        List<Customer> customerList =
                customerSevice.queryCustomerLst();

        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
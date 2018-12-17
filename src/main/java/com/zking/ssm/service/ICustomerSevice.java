package com.zking.ssm.service;

import com.zking.ssm.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerSevice {

    List<Customer> queryCustomerLst();
}
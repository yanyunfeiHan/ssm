package com.zking.ssm.service.imp;

import com.zking.ssm.mapper.CustomerMapper;
import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CustomerSeviceImpl implements ICustomerSevice {

    @Autowired
    private CustomerMapper customerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Customer> queryCustomerLst() {
        return customerMapper.queryCustomerLst();
    }
}

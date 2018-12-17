package com.zking.ssm.service;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Repository;

public interface ISysUserService {


    /**
     * 根据用户名
     * @param username
     * @return
     */
    SysUser queryUserByUserName(String username);
}
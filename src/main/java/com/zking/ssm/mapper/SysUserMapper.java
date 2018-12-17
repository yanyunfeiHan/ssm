package com.zking.ssm.mapper;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {


    /**
     * 根据用户名
     * @param username
     * @return
     */
    SysUser queryUserByUserName(String username);
}
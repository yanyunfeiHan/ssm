package com.zking.ssm.service.imp;

import com.zking.ssm.mapper.SysUserMapper;
import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional(readOnly = true)
    @Override
    public SysUser queryUserByUserName(String username) {
        return sysUserMapper.queryUserByUserName(username);
    }
}

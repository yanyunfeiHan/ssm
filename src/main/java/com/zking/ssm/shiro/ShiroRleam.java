package com.zking.ssm.shiro;

import com.zking.ssm.model.SysUser;
import com.zking.ssm.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRleam extends AuthorizingRealm {


    @Autowired
    private ISysUserService sysUserService;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = authenticationToken.getPrincipal().toString();
        String password = authenticationToken.getCredentials().toString();

        //根据username当前登录的永辉对象信息
        SysUser sysUser = sysUserService.queryUserByUserName(username);

        if(null==sysUser)
            throw new UnknownAccountException();

        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                sysUser.getUsername(),
                sysUser.getPassword(),
                this.getName());
        return simpleAuthenticationInfo;
    }
}

package com.zyc.p2p.key.sys.shiro;

import com.zyc.p2p.key.sys.model.SysUser;
import com.zyc.p2p.key.sys.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private ISysUserService sysUserService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取token中的用户名username
        String username = principalCollection.getPrimaryPrincipal().toString();
        //根据username获取对应的角色和权限
        Set<String> roles = null;
        Set<String> permissions = null;
        try {
            roles = sysUserService.findRoles(username);
            permissions = sysUserService.findPermissions(username);
        } catch (Exception e) {
            System.err.println("你出错啦");
        }
        System.out.println("roles="+roles);
        System.err.println("permissions=" + permissions);
        //将角色和权限信息设置到SimpleAuthorizationInfo
        SimpleAuthorizationInfo authz = new SimpleAuthorizationInfo();
        authz.setRoles(roles);
        authz.setStringPermissions(permissions);
        return authz;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = token.getCredentials().toString();
        //根据用户名获取对应的用户信息
        SysUser sysUser = null;
        try {
            sysUser = sysUserService.userLogin(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(null == sysUser){
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sysUser.getUsername(),
                sysUser.getPassword(),
                //盐
                ByteSource.Util.bytes(sysUser.getSalt()),
                this.getName()
        );
        return simpleAuthenticationInfo;
    }
}

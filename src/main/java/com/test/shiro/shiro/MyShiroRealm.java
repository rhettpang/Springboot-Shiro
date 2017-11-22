package com.test.shiro.shiro;

import com.test.shiro.entity.Permission;
import com.test.shiro.entity.User;
import com.test.shiro.service.PermissionService;
import com.test.shiro.service.UserService;
import com.test.shiro.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Created by pangkunkun on 2017/11/15.
 */
@Configuration
public class MyShiroRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public String getName() {
        return "myShiroRealm1";
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("doGetAuthenticationInfo1");
        MyUsernamePasswordToken myToken=(MyUsernamePasswordToken)token;
        //获取用户的输入的账号.
        String username = (String)myToken.getPrincipal();
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);
        System.out.println(user.toString());
        if(user==null){
            throw new UnknownAccountException();
        }
//        if (0==user.getEnable()) {
//            // 帐号锁定
//            throw new LockedAccountException();
//        }

        System.out.println("myToken.getSignature():"+myToken.getSignature());
        System.out.println("user.getPassword():"+user.getPassword());

        //此处使用的是user对象，不是username
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                getName()
        );
        System.out.println("authenticationInfo:"+authenticationInfo);

        return authenticationInfo;
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doGetAuthorizationInfo1");
        //User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        User user= (User) SecurityUtils.getSubject().getPrincipal();

        List<Permission> permissions=permissionService.findPermissionAndRoleNameByUserId(user.getUserId());
        System.out.println("permissions:"+permissions.size());
//        List<Role> roles=permissionService.findPermissionByUserId(user.getUserId());
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //这里赋给两个不存在的值，使controller中的权限验证失败，验证在此失败会继续进入myShiroRealm2验证权限
        info.addRole("as");
        info.addStringPermission("sdf");
//        for(Permission permission: permissions){
//            System.out.println("permission:"+permission.getPermission());
//            System.out.println("permission.getRoleName():"+permission.getRoleName());
//            info.addStringPermission(permission.getPermission());
//            info.addRole(permission.getRoleName());
//        }
        return info;
    }

}
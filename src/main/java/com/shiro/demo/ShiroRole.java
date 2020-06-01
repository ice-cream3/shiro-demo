package com.shiro.demo;

import com.shiro.demo.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: ShiroDemo
 * @Description:
 * @Author: lixl
 * @Date: 2020/5/11 23:06
 */
public class ShiroRole {

    @Test
    public void testHasRole() {
        Subject subject = ShiroUtil.login("classpath:shiro_role.ini", "admin", "123456");
        boolean role = subject.hasRole("role1");
        System.out.println("是否有此角色:"+role);
        boolean[] roles = subject.hasRoles(Arrays.asList("role1","role2","role3"));
        System.out.println("是否有此角色:"+roles[0]);
        System.out.println("是否有此角色:"+roles[1]);
        System.out.println("是否有此角色:"+roles[2]);
        boolean roleAll = subject.hasAllRoles(Arrays.asList("role1","role2","role3"));
        System.out.println("是否有全部角色:"+roleAll);
        boolean roleAll2 = subject.hasAllRoles(Arrays.asList("role1","role2"));
        System.out.println("是否有全部角色:"+roleAll2);
    }

    @Test
    public void testCheckRole() {
        Subject subject = ShiroUtil.login("classpath:shiro_role.ini", "admin", "123456");
        subject.checkRole("role1");
        System.out.println("是否有此角色,没有会抛出异常");
        subject.checkRoles(Arrays.asList("role1","role2","role3"));
        subject.checkRoles("role1","role2","role3");
    }
}

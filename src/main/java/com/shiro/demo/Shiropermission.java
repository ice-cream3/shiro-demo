package com.shiro.demo;

import com.shiro.demo.util.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: ShiroDemo
 * @Description:
 * @Author: lixl
 * @Date: 2020/5/11 23:06
 */
public class Shiropermission {

    @Test
    public void testHasRole() {
        Subject subject = ShiroUtil.login("classpath:shiro_permission.ini", "admin", "123456");
        boolean role = subject.isPermitted("user:select");
        System.out.println("是否有此权限:"+role);
        boolean[] roles = subject.isPermitted("user:select","user:update","user:del66");
        System.out.println("是否有此权限:"+roles[0]);
        System.out.println("是否有此权限:"+roles[1]);
        System.out.println("是否有此权限:"+roles[2]);
        boolean roleAll = subject.isPermittedAll("user:select","user:update","user:del");
        System.out.println("是否有全部权限:"+roleAll);
        boolean roleAll2 = subject.isPermittedAll("user:select","user:update","user:del66");
        System.out.println("是否有全部权限:"+roleAll2);
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

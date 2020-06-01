package com.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @ClassName: ShiroDemo
 * @Description:
 * @Author: lixl
 * @Date: 2020/5/11 23:06
 */
public class ShiroDemo {

    public static void main(String[] args) {
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc_realm.ini");

        SecurityManager securityManager = factory.getInstance();
        // 把securityManager绑定到 SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        try {
            // 创建token令牌
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "1234561");
            // 登陆
            subject.login(token);
            System.out.println("认证成功.");
        } catch (AuthenticationException e) {
            System.out.println("认证失败.");
            e.printStackTrace();
        }
        subject.logout();
    }
}

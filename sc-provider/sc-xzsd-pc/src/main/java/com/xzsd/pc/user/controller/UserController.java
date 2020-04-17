package com.xzsd.pc.user.controller;


import com.neusoft.core.restful.AppResponse;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查 User
 * @Author 林旭亮
 * @Date 2020-03-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * user 新增用户
     * @param userInfo
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-03-27
     */
    @PostMapping("addUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * user 用户列表(分页)
     * @param userInfo
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-03-21
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 删除用户
     * @param userCode
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-03-26
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId) {
        try {
            //获取用户id
            String userId1 = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userId,userId1);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 修改用户
     * @param userInfo
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-03-26
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            userInfo.setLastModifiedBy(userId);
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 查询用户详情
     * @param
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-03-26
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUserByUserCode(String userId) {
        try {
            return userService.getUserByUserCode(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

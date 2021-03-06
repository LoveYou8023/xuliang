package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;

import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author linxuliang
 * @Date 2020-04-1
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * demo 新增用户
     *
     * @param userInfo
     * @return
     * @Author linxuliang
     * @Date 2020-04-1
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(UserInfo userInfo) {
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return AppResponse.success("用户账号已存在，请重新输入！");
        }
        userInfo.setUserId(StringUtil.getCommonCode(2));
        String pwd = PasswordUtils.generatePassword(userInfo.getUserPassword());
        userInfo.setIsDeleted(0);
        userInfo.setUserPassword(pwd);
        // 新增用户
        int count = userDao.saveUser(userInfo);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询用户列表（分页）
     *
     * @param userInfo
     * @return
     * @Author linxuliang
     * @Date 2020-04-1
     */
    public AppResponse listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * demo 删除用户
     *
     * @param userCode
     * @param userId
     * @return
     * @Author linxuliang
     * @Date 2020-04-1
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId, String userId1) {
        List<String> listCode = Arrays.asList(userId.split(","));
        // 删除用户
        int count = userDao.deleteUser(listCode, userId1);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * demo 修改用户
     *
     * @param userInfo
     * @return
     * @Author linxuliang
     * @Date 2020-04-1
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }


    /**
     * demo 查询用户详情
     *
     * @param userCode
     * @return
     * @Author linxuliang
     * @Date 2020-04-1
     */
    public AppResponse getUserByUserCode(String userCode) {
        UserInfo userInfo = userDao.getUserByUserCode(userCode);
        return AppResponse.success("查询成功！", userInfo);
    }
}



package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;
    /**
     *          新增门店
     * @return AppResponse
     * @author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateUser(userId);
            AppResponse appResponse =storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 分页门店列表
     * @return
     */
    @RequestMapping( "listStore")
    public AppResponse listStore(StoreInfo storeInfo) {
        try {
            return storeService.listStoreByPage(storeInfo);
        } catch (Exception e) {
            logger.error("查询门店列表失败 ", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改门店信息
     * @param storeInfo
     * @return AppResponse
     * @author xuliang
     * @Date 2020-04-20
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUpdateUser(userId);
            return storeService.updateStore(storeInfo);
        } catch (Exception e) {
            logger.error("修改门店失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 门店删除
     * @param storeId
     * @return AppResponse
     * @author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeId,userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询门店信息详情
     * @param storeId
     * @return
     * @Author xuliang
     * @Date 2020-04-20
     */
    @RequestMapping("getStore")
    public AppResponse getStore(String storeId) {
        try {

            return storeService.getStore(storeId);
        } catch (Exception e) {
            logger.error("门店详情查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}

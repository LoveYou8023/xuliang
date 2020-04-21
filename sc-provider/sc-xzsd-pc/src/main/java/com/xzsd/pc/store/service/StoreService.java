package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo) {

        //门店编号
        storeInfo.setStoreId(StringUtil.getCommonCode(2));
        //门店邀请码
        storeInfo.setInviteCode( StringUtil.getCommonCode(2));
        storeInfo.setIsDelete(0);
        storeInfo.setVersion("0");
        // 新增门店
        int count = storeDao.addStore(storeInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 分页查询门店
     * @Author xuliang
     * @time 2020-04-20
     */
    public AppResponse listStoreByPage(StoreInfo storeInfo) {
        List<StoreInfo> driverInfoList = storeDao.listStoreByPage(storeInfo);
        return AppResponse.success("查询成功！", driverInfoList);
    }
    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     * @Author xuliang
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改司机信息
        int count = storeDao.updateStore(storeInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 删除门店
     * @param storeId
     * @param userId
     * @return
     * @Author xuliang
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId,String userId) {
        List<String> listDriver= Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = storeDao.deleteStore(listDriver,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
    /**
     * 查询门店详情
     * @param storeId
     * @Author xuliang
     * @Date 2020-04-20
     */
    public AppResponse getStore(String storeId) {
        StoreInfo storeInfo = storeDao.getStore(storeId);
        return AppResponse.success("查询成功！", storeInfo);
    }
}

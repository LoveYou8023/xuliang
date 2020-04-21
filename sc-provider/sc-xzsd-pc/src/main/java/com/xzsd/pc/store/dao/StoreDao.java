package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreDao {
    /**
     * 新增门店
     *
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 获取门店详情
     *
     * @param storeId
     * @return
     */
    StoreInfo getStore(@Param("storeId") String storeId);

    /**
     * 获取所有门店信息
     *
     * @param storeInfo
     * @return
     */
    List<StoreInfo> listStoreByPage(@Param("storeInfo") StoreInfo storeInfo);

    /**
     * 修改门店信息
     *
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 删除门店
     *
     * @param listStoreId
     * @param updateUser
     * @return
     */
    int deleteStore(@Param("listStoreId") List<String> listStoreId, @Param("updateUser") String updateUser);



}

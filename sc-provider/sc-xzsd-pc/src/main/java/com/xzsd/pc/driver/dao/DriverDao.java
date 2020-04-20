package com.xzsd.pc.driver.dao;
/**
 * 数据库相关接口
 */

import  com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsClassifyDao
 * @Description goodsClassify
 * @Author xuliang
 * @Date 2020-04-13
 */
/**
 * @author xuliang
 * @Mapper 与数据库相关联的意思
 */
@Mapper
public interface DriverDao {
    /**
     * 新增司机
     * @param
     * @return
     */
    int addDriver(DriverInfo driverInfo);
    /**
     * 司机是否存在
     * @param driverInfo
     * @return 返回门店个数
     */
    int countDriver(DriverInfo driverInfo);
    /**
     * 查询司机信息
     * @return 所有司机信息
     */
    List<DriverInfo> listDrivers(DriverInfo driverInfo);
    /**
     * 修改司机信息
     * @param driverInfo 司机信息
     * @return 修改结果
     */
    int updateDriver(DriverInfo driverInfo);
    /**
     * 删除司机
     * @param listDriver 选中的司机集合
     * @param userId 更新人
     * @return
     */
    int deleteDriver(@Param("listDriver")List<String> listDriver,@Param("userId") String userId);
    /**
     * 获取司机详细信息
     * @param driverId 司机id
     * @return 司机详细详细
     */
    DriverInfo getDriver(String driverId);
}

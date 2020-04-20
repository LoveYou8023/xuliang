package com.xzsd.pc.driver.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 司机新增
     * @param
     * @return
     * @Author linxuliang
     * @Date 2020-04-20
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo) {
        // 校验司机账号是否存在
        int countDriver = driverDao.countDriver(driverInfo);
        if(0 != countDriver) {
            return AppResponse.bizError("司机已存在，请重新输入！");
        }
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        driverInfo.setIdDelete(0);
        driverInfo.setVersion("0");
        // 新增司机
        int count = driverDao.addDriver(driverInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 分页查询司机
     * @Author xuliang
     * @time 2020-04-20
     */
    public AppResponse listDrivers(DriverInfo driverInfo) {
        List<DriverInfo> driverInfoList = driverDao.listDrivers(driverInfo);
        return AppResponse.success("查询成功！", driverInfoList);
    }
    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     * @Author xuliang
     * @Date 2020-04-20
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改司机信息
        int count = driverDao.updateDriver(driverInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 删除门店
     * @param driverId
     * @param userId
     * @return
     * @Author xuliang
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverId,String userId) {
        List<String> listDriver= Arrays.asList(driverId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = driverDao.deleteDriver(listDriver,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
    /**
     * 查询司机详情
     * @param driverId
     * @Author xuliang
     * @Date 2020-04-20
     */
    public AppResponse getDriver(String driverId) {
        DriverInfo driverInfo = driverDao.getDriver(driverId);
        return AppResponse.success("查询成功！", driverInfo);
    }
}
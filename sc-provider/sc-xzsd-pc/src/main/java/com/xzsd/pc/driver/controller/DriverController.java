package com.xzsd.pc.driver.controller;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * 司机管理
 * @author linxuliang
 * @time 2020-04-20
 */
@Service
@RestController
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;
    /**
     *          新增司机
     * @return AppResponse
     * @author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateUser(userId);
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 分页司机列表
     * @return
     */
    @RequestMapping( "listDrivers")
    public AppResponse listDrivers(DriverInfo driverInfo) {
        try {
            return driverService.listDrivers(driverInfo);
        } catch (Exception e) {
            logger.error("查询司机失败 ", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改司机信息
     * @param driverInfo
     * @return AppResponse
     * @author xuliang
     * @Date 2020-04-20
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setSupdateUser(userId);
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error("修改司机失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 司机删除
     * @param driverId
     * @return AppResponse
     * @author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(driverId,userId);
        } catch (Exception e) {
            logger.error("司机删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询司机信息详情
     * @param driverId
     * @return
     * @Author xuliang
     * @Date 2020-04-20
     */
    @RequestMapping("getDriver")
    public AppResponse getStore(String driverId) {
        try {
            return driverService.getDriver(driverId);
        } catch (Exception e) {
            logger.error("司机详情查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

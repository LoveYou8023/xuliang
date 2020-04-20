package com.xzsd.pc.order.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetail;
import com.xzsd.pc.order.entity.OrderInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 订单管理实现类
 * @author linxuliang
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 订单列表查询
     */
    public AppResponse listOrders(OrderDetail orderDetail){
        orderDetail.setUpdateUser(SecurityUtils.getCurrentUserId());
        List<OrderDetail> list=orderDao.listOrdersByPage(orderDetail);
        // 包装Page对象
        PageInfo<OrderDetail> pageData = new PageInfo<OrderDetail>(list);
        return AppResponse.success("查询成功！", pageData);
    }
    /**
     * 订单详情查询
     */
    public AppResponse getListOrder(String orderId){
        List<OrderInfo> listOrderDetail=orderDao.getListOrder(orderId);
        // 包装Page对象
        PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(listOrderDetail);
        return AppResponse.success("查询成功！", pageData);
    }
    /**
     * 修改订单状态接口
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo){
        //获取要修改的订单编号
        List<String> orderIds = Arrays.asList(orderInfo.getOrderId().split(","));
        //获取版本号，版本号都相等只取一个即可
        String version=orderInfo.getVersion();
        //获取要修改的状态值
        String updateOrderState=orderInfo.getOrderStateId();
        //获取修改人:当前登录人的id
        String updateUser = SecurityUtils.getCurrentUserId();
        int count = orderDao.updateOrderState(orderIds,version,updateOrderState,updateUser);
        if(count == 0){
            return AppResponse.versionError("修改失败");
        }
        return AppResponse.success("修改成功");

    }
}

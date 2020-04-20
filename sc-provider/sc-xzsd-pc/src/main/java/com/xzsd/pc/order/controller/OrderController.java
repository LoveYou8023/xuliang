package com.xzsd.pc.order.controller;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderDetail;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Derecation 订单管理
 * @Author linxuliang
 * @Date 2020-04-19
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;
    /**
     * 订单详情
     * @return
     * @Author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("getListOrder")
    public AppResponse getListOrder(String orderId){
        try{
            return orderService.getListOrder(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 订单列表
     * @Author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("listOrders")
    public AppResponse listOrders(OrderDetail orderId){
        try{
            return orderService.listOrders(orderId);
        }catch (Exception e){
            logger.error("分页查询订单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改订单
     * @return
     * @Author linxuliang
     * @Date 2020-04-20
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo){
        try{
            return orderService.updateOrderState(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
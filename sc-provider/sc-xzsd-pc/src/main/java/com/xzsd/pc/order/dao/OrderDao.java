package com.xzsd.pc.order.dao;
import com.xzsd.pc.order.entity.OrderDetail;
import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @ClassName OrderDao
 * @Derecation 订单管理接口类
 * @Author linxuliang
 * @Date 2020-04-20
 */
@Mapper
public interface OrderDao {
    /**
     * 查询订单详情接口
     * @param orderId
     * @return
     */
    List<OrderInfo> getListOrder(@Param("orderId") String orderId);

    /**
     * 分页查询订单接口
     */
    List<OrderDetail> listOrdersByPage(OrderDetail orderDetail);
    /**
     * 修改订单状态接口
     * @param
     * @return
     */
    int updateOrderState(@Param("orderIds") List<String> updateOrderstate,@Param("version") String version,
                         @Param("updateOrderState") String updateOrderState,@Param("userId")String userId);
}
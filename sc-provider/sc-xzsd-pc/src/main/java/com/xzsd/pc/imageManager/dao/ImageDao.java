package com.xzsd.pc.imageManager.dao;

import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.imageManager.entity.RotationChart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageDao {

    /**
     *
     * 增加轮播图
     * @return
     */

    int addChart(RotationChart rotationChart);

    /**
     * 删除轮播图
     *  @param listCode 选中的轮播图商品编号集合
     *  @param userId 更新人
     */
    int deleteChart(List<String> listCode, @Param("userId") String userId);
    /**
     * 修改轮播图的状态
     */
    int updateStatus(List<String>listStatusCode,@Param("imageStatus") String imageStatus);

    /**
     * 查询轮播图列表
     * @return
     */
   List<RotationChart> listRotationChart(RotationChart rotationChart);
    /**
     * 选择商品列表
     */
    List<Goods> listGoods(Goods goods);
}

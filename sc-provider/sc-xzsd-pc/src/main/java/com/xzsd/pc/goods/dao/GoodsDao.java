package com.xzsd.pc.goods.dao;




import com.xzsd.pc.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.awt.*;

public interface GoodsDao {
    /**
     * 验证商品是否存在
     */
    int countGoods(Goods goods);

    /**
     * 添加商品
     */
    int saveGoods(Goods goods);

    /**
     *查询所有商品
     */
    List<Goods> listGoodsByPage(Goods goods);
    /**
     * 删除商品信息
     * @param listCode 选中的商品编号集合
     * @param userId 更新人
     * @return
     */
    int deleteGoods(List<String> listCode,@Param("userId") String userId);
    /**
     * 修改商品
     */
    int updateGoods(Goods goods);
    /**
     * 查询商品信息
     */
    Goods getGoodsByGoodsCode( @Param("goodsCode") String goodsCode);
    /**
     * 商品上下架
     */
   int goodsStatus(List<String> listCode,String status);

}

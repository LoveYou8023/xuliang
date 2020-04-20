package com.xzsd.pc.hotGoods.dao;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.hotGoods.entity.HotGoods;
import java.util.List;

/**
 *热门商品Dao
 * author linxuliang
 * date 2020/4/18
 */
public interface HotGoodsDao {
    /**
     * 新增热门商品
     */
    int addHotGoods(HotGoods hotGoods);

    /**
     * 查询热门商品详情
     */

    HotGoods getHotGoods(String hotGoodsId);
    /**
     * 热门商品列表(分页查询)
     * @param hotGoods
     * @return
     */
    List<HotGoods> listHotGoods(HotGoods hotGoods);
    /**
     * 修改热门商品
     */
    int updateHotGoods(HotGoods hotGoods);
    /**
     * 获得商品的展示数量
     */
   int getHotGoodsShowNum();
    /**
     * 修改商品的展示数量
     */

    int updateHotGoodsShowNum(int number,String version);
    /**
     *删除热门商品
     */
    int deleteHotGoods(List<String> hotGoods,String UserId);
    /**
     * 显示商品列表
     */
    List<Goods> listGoods(Goods goods);
}

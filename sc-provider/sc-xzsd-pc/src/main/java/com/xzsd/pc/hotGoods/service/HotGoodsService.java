package com.xzsd.pc.hotGoods.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 热门商品实现类
 * @Author linxuliang
 * @Date 2020-04-18
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;
    /**
     * 新增热门商品
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoods hotGoods){
        hotGoods.setHotGoodsId("hg"+StringUtil.getCommonCode(2));
        hotGoods.setIsDeleted(0);
        int count=hotGoodsDao.addHotGoods(hotGoods);
        if(0==count){
            return AppResponse.success("新增失败!");
        }
        return AppResponse.success("新增成功");
    }
    /**
     * 查询热门商品详情
     */

    public AppResponse getHotGoods(String hotGoodsId){
        HotGoods hotGoods=hotGoodsDao.getHotGoods(hotGoodsId);
        return AppResponse.success("查询成功",hotGoods);
    }

    /**
     * 热门商品列表(分页查询)
     * @param hotGoods
     * @return
     */
    public AppResponse listHotGoods(HotGoods hotGoods){
        List<HotGoods> listHotGoods=hotGoodsDao.listHotGoods(hotGoods);
        return  AppResponse.success("查询成功",listHotGoods);
    }
    /**
     * 修改热门商品
     */
    @Transactional(rollbackFor = Exception.class)
    public  AppResponse updateHotGoods(HotGoods hotGoods){
      int count = hotGoodsDao.updateHotGoods(hotGoods);
      if(0==count){
          return AppResponse.success("修改失败");
      }
      return  AppResponse.success("修改成功");
    }
    /**
     * 获得商品的展示数量
     */
    public AppResponse getHotGoodsShowNum(){
          return AppResponse.success("查询成功！",hotGoodsDao.getHotGoodsShowNum());
    }
    /**
     * 修改商品的展示数量
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsShowNum(int hotGoodsShowNum,String version){
         int count=hotGoodsDao.updateHotGoodsShowNum(hotGoodsShowNum,version);
         if(0==count){
             return AppResponse.success("修改失败！");
         }
         return AppResponse.success("修改成功！");
    }
    /**
     *删除热门商品
     */
    @Transactional(rollbackFor = Exception.class)
    public  AppResponse deleteHotGoods(String hotGoodsId){
        List<String> listCode = Arrays.asList(hotGoodsId.split(","));
        String userId = SecurityUtils.getCurrentUserId();
        int count = hotGoodsDao.deleteHotGoods(listCode,userId);
        if(0==count){
            return AppResponse.success("修改失败！");
        }
        return AppResponse.success("修改成功!");
    }
    /**
     * 选择商品列表
     */

    public AppResponse listGoods(Goods goods){
          List<Goods> listgoods=hotGoodsDao.listGoods(goods);
          return AppResponse.success("查询成功!",listgoods);
    }
}

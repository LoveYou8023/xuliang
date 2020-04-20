package com.xzsd.pc.hotGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoods;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("hotGoods")
/**
 *热门商品位管理
 */
public class HotController {
    private static final Logger logger = LoggerFactory.getLogger(HotController.class);
    @Resource
    private HotGoodsService hotGoodsService;
    /**
     * 热门位商品新增
     */
    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoods hotGoods){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            hotGoods.setCreateBy(userId);
            AppResponse appResponse=hotGoodsService.addHotGoods(hotGoods);
            return  appResponse;
        }catch (Exception e){
            logger.error("新增失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门商品详情
     *
     */
    @PostMapping("getHotGoods")
    public AppResponse getHotGoods(String hotGoodsId){
        try{
            return hotGoodsService.getHotGoods(hotGoodsId);
        }catch (Exception e){
            logger.error("查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 热门商品列表(分页查询)
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(HotGoods hotGoods){
        try {
            return hotGoodsService.listHotGoods(hotGoods);
        }catch (Exception e){
            logger.error("查询列表失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }
    /**
     * 修改热门商品
     */
    @PostMapping("updateHotGoods")
    public  AppResponse updateHotGoods(HotGoods hotGoods){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoods.setLastModifiedBy(userId);
            return hotGoodsService.updateHotGoods(hotGoods);
        }catch (Exception e){
            logger.error("修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 获得商品的展示数量
     */
    @PostMapping("getHotGoodsShowNum")
    public AppResponse getHotGoodsShowNum(){
        try{
            return hotGoodsService.getHotGoodsShowNum();
        }catch (Exception e){
            logger.error("查询失败!",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品的展示数量
     */
    @PostMapping("updateHotGoodsShowNum")
   public AppResponse updateHotGoodsShowNum(int number,String version){
       try{
           return hotGoodsService.updateHotGoodsShowNum(number,version);
       }catch (Exception e){
           logger.error("查询失败!",e);
           System.out.println(e.toString());
           throw e;
       }
   }
    /**
     * 删除热门商品
     */
    @PostMapping("deleteHotGoods")
    public  AppResponse deleteHotGoods(String hotGoodsId){
        try{
            return hotGoodsService.deleteHotGoods(hotGoodsId);
        }catch (Exception e){
            logger.error("删除失败!",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 选择商品列表
     */
    @PostMapping("listGoods")
    public AppResponse listGoods(Goods goods){
        try {
            AppResponse appResponse = hotGoodsService.listGoods(goods);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

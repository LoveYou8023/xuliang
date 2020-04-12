package com.xzsd.pc.goods.controller;








import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品管理
 * @author linxuliang
 * @time 2020-4-1
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;


    /**
     * demo 新增商品
     *
     * 增加商品
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-04-1
     */
    @PostMapping("/addgoods")
    public AppResponse addgoods(Goods goods){

        try {
            //获取用户id
            String userId2 = SecurityUtils.getCurrentUserId();
            goods.setCreateBy(userId2);
            AppResponse appResponse = goodsService.saveGoods(goods);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }


    }

    /**
     *
     * 修改商品
     * @return AppResponse
     * @author 林旭亮
     * @Date 2020-04-1
     */
    @PostMapping("/updategoods")
    public AppResponse updategoods(Goods goods){

        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goods.setCreateBy(userId);
            goods.setLastModifiedBy(userId);
            return goodsService.updateGoods(goods);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }


    }
    /**
     * demo 删除商品
     *
     * @param goodsCode
     * @return AppResponse
     * @author linxuliang
     * @Date 2020-4-1
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsCode, userId);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * demo 商品列表(分页)
     *
     * @param goods
     * @return AppResponse
     * @author Linxuliang
     * @Date 2020-04-1
     */
    @RequestMapping("/listGoods")
    public AppResponse listGoods(Goods goods) {
        try {
            return goodsService.listGoods(goods);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    @RequestMapping("/goodsInfo")
    public AppResponse  goodsInfo(String goodsCode){
        try {

            return goodsService.getGoodsByGoodsCode(goodsCode);
        } catch (Exception e) {
            logger.error("商品查询失败", e);
            System.out.println(e.toString());
            throw e;
        }

    }
}

package com.xzsd.pc.imageManager.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.imageManager.entity.RotationChart;
import com.xzsd.pc.imageManager.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 轮播图管理
 * @author Linxuliang
 * @Date 2020-4-10
 */
@RestController
@RequestMapping("imageManager")
public class ImageController {
    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    @Resource
    private ImageService imageService;
    /**
     * 轮播图新增
     */
    @PostMapping("addRotationChart")
    public AppResponse addRotationChart(RotationChart rotationChart){

        try {
            //获取用户id
            String userId2 = SecurityUtils.getCurrentUserId();
            rotationChart.setCreateBy(userId2);
            AppResponse appResponse = imageService.saveRotationChart(rotationChart);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图状态修改
     * @return
     */
    @PostMapping("updateStatus")
    public AppResponse updateStatus(String goodsCode,String Status){
        try {
            AppResponse appResponse = imageService.updateStatus(goodsCode,Status);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除轮播图
     * @param goodsCode
     * @return
     */
    @PostMapping("deleteRotationChart")
    public AppResponse deleteRotationChart(String goodsCode){

        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return imageService.deleteChart(goodsCode, userId);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 轮播图列表查询
     */
    @PostMapping("listRotationChart")
    public AppResponse listRotationChart(RotationChart rotationChart){
        try {
            AppResponse appResponse = imageService.listRotationChart(rotationChart);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }


    }
    /**
     * 选择商品列表查询
     *
     */
    @PostMapping("listGoods")
    public AppResponse listGoods(Goods goods){
        try {
            AppResponse appResponse = imageService.listgoods(goods);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图列表查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}

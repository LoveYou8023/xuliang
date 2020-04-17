package com.xzsd.pc.goodsClassify.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodsClassify.entity.ClassifyInfo;
import com.xzsd.pc.goodsClassify.service.ClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类管理
 * @author
 * date 2020-4-15
 */
@RestController
@RequestMapping("goodsClassify")
public class ClassifyController {
    private static final Logger logger = LoggerFactory.getLogger(ClassifyController.class);
    @Resource
    ClassifyService classifyService;
    /**
     * 新增商品分类
     */
    @PostMapping("addGoodsClassify")
    public AppResponse addGoodsClassify(ClassifyInfo classifyInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            classifyInfo.setCreateBy(userId);
            AppResponse appResponse = classifyService.saveGoodsClassify(classifyInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }

    }
    /**
     * 修改商品分类
     */
    @PostMapping("updateClassify")
    public AppResponse updateClassify(ClassifyInfo classifyInfo){
        try{
          AppResponse appResponse=classifyService.updateClassify(classifyInfo);
          return appResponse;
        }catch (Exception e){
            logger.error("商品分类修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     *删除商品分类
     */
    @PostMapping("deleteClassify")
    public AppResponse deleteClassify(String classifyId){
        try{
            AppResponse appResponse=classifyService.deleteClassify(classifyId);
            return appResponse;
        }catch (Exception e){
            logger.error("删除失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 查询商品分类列表
     * @return
     */
    @PostMapping("listClassify")
    public AppResponse listClassify(){
        try {
            AppResponse appResponse = classifyService.listClassify();
            return appResponse;
        }catch (Exception e){
            logger.error("查询商品分类列表失败",e);
            System.out.println(e.toString());
            throw e;

        }
    }
    /**
     * 查询商品分类详情
     */
    @PostMapping("classifyInfo")
    public AppResponse classifyInfo(String classifyCode){
        try{
            AppResponse appResponse=classifyService.classifyInfo(classifyCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询商品分类详情失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }
}

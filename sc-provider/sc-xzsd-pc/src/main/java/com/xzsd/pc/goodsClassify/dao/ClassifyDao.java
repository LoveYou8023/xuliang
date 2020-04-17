package com.xzsd.pc.goodsClassify.dao;

import com.xzsd.pc.goodsClassify.entity.ClassifyInfo;

import java.util.List;

/**
 * 商品分类接口
 */
public interface ClassifyDao {
    /**
     * 检验商品分类是否存在
     *
     */
    int countGoodsClassify(ClassifyInfo classifyInfo);
    /**
     * 商品分类新增
     *
     */
    int saveGoodsClassify(ClassifyInfo classifyInfo);
    /**
     * 商品分类修改
     */
    int updateGoodsClassify(ClassifyInfo classifyInfo);
    /**
     * 商品分类列表显示
     */
    List<ClassifyInfo> listClassifyInfo();
    /**
     * 商品分类详情
     */
    ClassifyInfo classifyInfo(String classifyCode);
    /**
     * 商品分类删除
     */
    int deleteClassify(String classifyId);
    /**
     * 删除一级分类
     */
    int deleteFirstClassify(String classifyId);
    /**
     * 判断是否有二级分类
     */
    int isHaveSecond(String classifyId);
    /**
     * 查询下拉框
     */
    List<ClassifyInfo> listGoodsClassify(String classifyId);

}

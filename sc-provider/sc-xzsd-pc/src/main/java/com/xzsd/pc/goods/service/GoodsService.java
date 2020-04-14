package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.Goods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;
    /**
     * 新增商品
     * @author 林旭亮
     * date 2020/3/29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoods(Goods goods){
        int countGoods =goodsDao.countGoods(goods);
        if (0 != countGoods) {
            return AppResponse.success("商品号已存在，请重新输入商品名称！");
        }
        goods.setGoodsCode(StringUtil.getCommonCode(2));
        goods.setIsDeleted(0);
        // 新增商品
        int count = goodsDao.saveGoods(goods);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 修改商品
     * @author 林旭亮
     * date 2020/3/29
     */
    public AppResponse updateGoods(Goods goods){
        AppResponse appResponse = AppResponse.success("修改成功");

        // 修改用户信息
        int count = goodsDao.updateGoods(goods);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;


    }
    /**
     *
     *删除商品
     * @param goodsCode
     * @param userId
     * @return
     * @Author linxuliang
     * @Date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode, String userId) {
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        // 删除商品
        int count = goodsDao.deleteGoods(listCode, userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
    /**
     * demo 查询商品列表（分页）
     *
     * @param goods
     * @return
     * @Author linxuliang
     * @Date 2020-03-21
     */
    public AppResponse listGoods(Goods goods) {
        PageHelper.startPage(goods.getPageNum(), goods.getPageSize());
        List<Goods> goodsList = goodsDao.listGoodsByPage(goods);
        // 包装Page对象
        PageInfo<Goods> pageData = new PageInfo<Goods>(goodsList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 通过商品编码查询商品信息
     * @author 林旭亮
     * @Date 2020-4-1
     */
    public AppResponse getGoodsByGoodsCode(String goodsCode){
     Goods goodsInfo=goodsDao.getGoodsByGoodsCode(goodsCode);
     return AppResponse.success("查询成功",goodsInfo);

    }
    /**
     * 商品上下架
     * 0表示上架 1表示下架 2
     */
    @Transactional(rollbackFor =Exception.class)
    public AppResponse goodsStatus(String goodsCode,String Status){
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        int count=goodsDao.goodsStatus(listCode,Status);
        if(0==count){
            return AppResponse.success("商品状态修改失败！");
        }
        return AppResponse.success("修改成功！");
    }

}

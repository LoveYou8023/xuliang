package com.xzsd.pc.imageManager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.goods.entity.Goods;
import com.xzsd.pc.imageManager.dao.ImageDao;
import com.xzsd.pc.imageManager.entity.RotationChart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ImageService {
    @Resource
    ImageDao imageDao;
    /**
     * 新增轮播图
     * @author 林旭亮
     * Date  2020-4-13
     */
    @Transactional(rollbackFor=Exception.class)
    public AppResponse saveRotationChart(RotationChart rotationChart){
         rotationChart.setIsDeleted(0);
        int count =imageDao.addChart(rotationChart);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 轮播图删除
     * @param goodsCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor =Exception.class)
    public  AppResponse deleteChart(String goodsCode,String userId){

        List<String> listCode = Arrays.asList(goodsCode.split(","));
        // 删除商品
        int count = imageDao.deleteChart(listCode, userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * 轮播图列表查询
     * @return
     */
    public AppResponse  listRotationChart(RotationChart rotationChart){
        PageHelper.startPage(rotationChart.getPageNum(), rotationChart.getPageSize());
    List<RotationChart> listChart =imageDao.listRotationChart(rotationChart);
        // 包装Page对象
        PageInfo<RotationChart> pageData = new PageInfo<RotationChart>(listChart);
    return  AppResponse.success("查询成功！",pageData);

    }
    /**
     * 查询商品列表
     */
    public AppResponse listGoods(Goods goods){
        PageHelper.startPage(goods.getPageNum(), goods.getPageSize());
        List<Goods> listGoods=imageDao.listGoods(goods);
        // 包装Page对象
        PageInfo<Goods> pageData = new PageInfo<Goods>(listGoods);
        return AppResponse.success("查询成功！",pageData);
    }
}

package com.xzsd.pc.goodsClassify.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goodsClassify.dao.ClassifyDao;
import com.xzsd.pc.goodsClassify.entity.ClassifyInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassifyService {
    @Resource
    ClassifyDao classifyDao;
    /**
     * 新增商品分类
     * 一级分类传0 二级分类传一级分类编号
     *
     * */
    @Transactional(rollbackFor = Exception.class)
    public  AppResponse saveGoodsClassify(ClassifyInfo classifyInfo){
        // 校验商品分类是否存在
        int countGoodsClassify = classifyDao.countGoodsClassify(classifyInfo);
        if (0 != countGoodsClassify) {
            return AppResponse.success("该商品分类名称已经存在，请重新输入！");
        }

        classifyInfo.setClassifyId(StringUtil.getCommonCode(2));

        classifyInfo.setIsDeleted(0);
        // 新增用户
        int count = classifyDao.saveGoodsClassify(classifyInfo);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");

    }
    /**
     * 修改商品分类
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClassify(ClassifyInfo classifyInfo){
        int count=classifyDao.updateGoodsClassify(classifyInfo);
        if(0==count){
            return AppResponse.success("修改失败!");
        }
        return AppResponse.success("商品分类修改成功！");


    }

    /**
     * 删除商品分类
     * @param classifyCode
     * @return
     */
     @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteClassify(String classifyCode){
      int count = classifyDao.isHaveSecond(classifyCode);
      if(count==0){    //没有二级分类
          int count2=classifyDao.deleteClassify(classifyCode);
          if(count2==0){ //判断是否删除成功
              return AppResponse.success("删除失败！");

          }
          return AppResponse.success("删除成功!");

      }
      //有二级分类
         int count3=classifyDao.deleteClassify(classifyCode);//删除一级分类
      int count4=classifyDao.deleteFirstClassify(classifyCode);//删除一级分类下的二级分类
      if (count4==0&&count3==0){
          return AppResponse.success("删除失败！");
      }
      return AppResponse.success("删除成功！");

     }
    /**
     * 查询分类列表
     */
    public AppResponse listClassify(){
        List<ClassifyInfo> listClassify =classifyDao.listClassifyInfo();

        return AppResponse.success("查询成功",listClassify);
    }
    /**
     * 查询商品分类详情
     */
    public AppResponse classifyInfo(String classifyId){
        ClassifyInfo classifyInfo=classifyDao.classifyInfo(classifyId);

        return AppResponse.success("查询分类成功!",classifyInfo);
    }
}

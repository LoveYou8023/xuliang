package com.xzsd.pc.region.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.region.dao.RegionDao;
import com.xzsd.pc.region.entity.Region;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 省市区下拉接口实现类
 * date 2020/4/21
 */
@Service
public class RegionService {

    @Resource
    private RegionDao regionDao;
    /**
     * 省市区下拉接口
     */
    public AppResponse listArea(String  areaId){
        List<Region> listRegionName =regionDao.listArea(areaId);
        return AppResponse.success("查询成功",listRegionName);
    }
}

package com.xzsd.pc.region.dao;

import com.xzsd.pc.region.entity.Region;

import java.util.List;

/**
 * 省市区下拉接口
 * date 2020/4/21
 */
public interface RegionDao {
    List<Region> listArea(String areaId);
}

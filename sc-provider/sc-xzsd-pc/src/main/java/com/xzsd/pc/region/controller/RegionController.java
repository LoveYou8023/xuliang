package com.xzsd.pc.region.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.region.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 省市区表
 * 日期 2020/4/21
 *
 */
@RestController
@RequestMapping("selectCombox")
public class RegionController {
    private static final Logger logger = LoggerFactory.getLogger(RegionController.class);
    @Resource
    private RegionService regionService;
    /**
     * 省市区接口查询
     * 日期 2020/4/21
     */
    @PostMapping("listArea")
    public AppResponse listArea(String areaId){
        try{
            return regionService.listArea(areaId);
        }catch (Exception e){
            logger.error("查询失败！",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}

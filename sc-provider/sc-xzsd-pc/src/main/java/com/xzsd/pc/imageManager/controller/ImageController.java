package com.xzsd.pc.imageManager.controller;

import com.xzsd.pc.imageManager.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
}

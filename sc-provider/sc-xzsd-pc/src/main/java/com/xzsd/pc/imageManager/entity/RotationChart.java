package com.xzsd.pc.imageManager.entity;

import java.util.Date;

public class RotationChart {


/**
 * @description 商品实体类
 * @Author 林旭亮
 * @date 2020/4/10
 */
/**

 /**
 * 轮播图地址
 */
  private String imagePath;

    /**
     *轮播图排序
     */
  private  String slideshowNum;
    /**
     *轮播图状态
     */
   private  int slideshowStateId;
    /**
     *有效期起
     */
    private Date  startTime;
    /**
     * 首页轮播图编号
     */
    private String slideshowId;
    /**
     *有效期止
     */
    private Date endTime;
    /**
     *商品编码
     */
    private String goodsId;
    /**
     * 是否删除
     */
    private int isDeleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSlideshowNum() {
        return slideshowNum;
    }

    public void setSlideshowNum(String slideshowNum) {
        this.slideshowNum = slideshowNum;
    }

    public int getSlideshowStateId() {
        return slideshowStateId;
    }

    public void setSlideshowStateId(int slideshowStateId) {
        this.slideshowStateId = slideshowStateId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSlideshowId() {
        return slideshowId;
    }

    public void setSlideshowId(String slideshowId) {
        this.slideshowId = slideshowId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 页数
     * @return
     */
    private int pageNum;

    /**
     * 每页显示的条数
     * @return
     */
    private int pageSize;




}

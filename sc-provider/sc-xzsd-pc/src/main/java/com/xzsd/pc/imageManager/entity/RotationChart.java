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
  private String imageUrl;

    /**
     *轮播图排序
     */
  private  String imageNo;
    /**
     *轮播图状态
     */
   private  int imageStatus;
    /**
     *有效期起
     */
    private Date  imageStartTime;
    /**
     *有效期止
     */
    private Date imageEndTime;
    /**
     *商品编码
     */
    private String goodsCode;
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

    public int getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(int imageStatus) {
        this.imageStatus = imageStatus;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageNo() {
        return imageNo;
    }

    public void setImageNo(String imageNo) {
        this.imageNo = imageNo;
    }

    public int getInmageStatus() {
        return imageStatus;
    }

    public void setInmageStatus(int inmageStatus) {
        this.imageStatus = inmageStatus;
    }

    public Date getImageStartTime() {
        return imageStartTime;
    }

    public void setImageStartTime(Date imageStartTime) {
        this.imageStartTime = imageStartTime;
    }

    public Date getImageEndTime() {
        return imageEndTime;
    }

    public void setImageEndTime(Date imageEndTime) {
        this.imageEndTime = imageEndTime;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }


}

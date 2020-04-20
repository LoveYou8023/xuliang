package com.xzsd.pc.driver.entity;

/**
 * 商品分类实体类
 * @Description goodsClassify
 * @Author xuliang
 * @Date 2020-04-20
 */
public class DriverInfo {
    /**
     * 一共多少页
     */
    private int pageSize;
    /**
     * 当前多少页
     */
    private int pageNum;

    /**
     * 司机名字
     */
    private String userName;
    /**
     * 联系电话（司机电话）
     */
    private String phone;
    /**
     * 用户头像图片路径
     */
    private String imagePath;
    /**
     * 司机账号
     */
    private String userAcct;

    /**
     * 司机密码
     */
    private String userPassword;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 省编号
     */
    private String provinceId;
    /**
     * 省名称
     */
    private String provinceName;
    /**
     * 市编号
     */
    private String cityId;
    /**
     * 市名称
     */
    private String cityName;
    /**
     * 区编号
     */
    private String areaId;
    /**
     * 区名称
     */
    private String areaName;
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 删除标记
     */
    private int idDelete;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改人
     */
    private String supdateUser;
    /**
     * 修改时间
     */
    private String supdateTime;
    /**
     * 版本号
     */
    private String version;


    /**
     * 以下是get set函数
     */


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(int idDelete) {
        this.idDelete = idDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSupdateUser() {
        return supdateUser;
    }

    public void setSupdateUser(String supdateUser) {
        this.supdateUser = supdateUser;
    }

    public String getSupdateTime() {
        return supdateTime;
    }

    public void setSupdateTime(String supdateTime) {
        this.supdateTime = supdateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
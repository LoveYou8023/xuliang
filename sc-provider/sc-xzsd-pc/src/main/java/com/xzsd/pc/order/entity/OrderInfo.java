package com.xzsd.pc.order.entity;

public class OrderInfo {

        /**
         * 订单编号
         */
        private String orderId;
        /**
         * 门店编号
         */
        private String storeId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getReducedAllPrice() {
        return reducedAllPrice;
    }

    public void setReducedAllPrice(String reducedAllPrice) {
        this.reducedAllPrice = reducedAllPrice;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
         * 订单总价
         */
        private String orderAllCost;
        /**
         * 订单状态编号
         */
        private String orderStateId;
    /**
         * 客户编号
         */
       private String userId;
        /**
         * 付款时间
         */
        private String payTime;
        /**
         * 优惠金额
         */
        private String reducedAllPrice;
        /**
         * 订单备注
         */
        private String orderComment;
        /**
         * 收件人姓名
         */
        private String userName;
        /**
         * 收件人电话
         */
        private String phone;
        /**
         * 删除标记
         */
        private int isDeleted;
        /**
         * 创作时间
         */
        private String createTime;
        /**
         * 创作者
         */
        private String createUser;
        /**
         * 更新时间
         */
        private String updateTime;
        /**
         * 更新者
         */
        private String updateUser;
        /**
         * 版本号
         */
        private String version;

}

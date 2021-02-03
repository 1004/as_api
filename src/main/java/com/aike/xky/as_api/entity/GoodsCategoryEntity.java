package com.aike.xky.as_api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/3 5:56 下午
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsCategoryEntity {
    /**
     * 商品id
     */
    private int categoryId;
    /**
     * 商品名字
     */
    private String categoryName;
    /**
     * 创建时间
     */
    private String createTime;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

package com.aike.xky.as_api.service;

import com.aike.xky.as_api.entity.GoodsCategoryEntity;
import com.aike.xky.as_api.mapper.GoodsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/3 6:10 下午
 */
@Repository
public class GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper categoryMapper;

    /**
     * 添加分类
     *
     * @param categroy_name
     * @param create_time
     */
    public void addGoodsCategory(String categroy_name, String create_time) {
        categoryMapper.addGoodsCategory(categroy_name, create_time);
    }

    /**
     * 删除分类
     *
     * @param category_id
     */
    public void deleteGoodsCategory(String category_id) {
        categoryMapper.deleteGoodsCategory(category_id);
    }


    /**
     * 查询所有的分类
     *
     * @return
     */
    public List<GoodsCategoryEntity> queryAllGoodsCategory() {
        return categoryMapper.queryAllGoodsCategory();
    }
}

package com.aike.xky.as_api.mapper;

import com.aike.xky.as_api.entity.GoodsCategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsCategoryMapper {

    /**
     * 添加分类
     *
     * @param categroy_name
     * @param create_time
     */
    public void addGoodsCategory(String categroy_name, String create_time);

    /**
     * 删除分类
     *
     * @param category_id
     */
    public void deleteGoodsCategory(String category_id);


    /**
     * 查询所有的分类
     *
     * @return
     */
    public List<GoodsCategoryEntity> queryAllGoodsCategory();
}

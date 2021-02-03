package com.aike.xky.as_api.controller;

import com.aike.xky.as_api.entity.GoodsCategoryEntity;
import com.aike.xky.as_api.entity.base.ResponseEntity;
import com.aike.xky.as_api.service.GoodsCategoryService;
import com.aike.xky.as_api.utils.DateUtil;
import com.aike.xky.as_api.utils.PageUtiil;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aike.xky.as_api.entity.base.ResponseCode.RC_GOODS_CATEGROY_REPEAT;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/3 6:12 下午
 */
@Api(tags = {"GoodsCategory"})
@RestController
@RequestMapping("/goods/category")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService categoryService;

    /**
     * 添加分类
     *
     * @param categroy_name
     */
    @ApiOperation("添加分类")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addGoodsCategory(@RequestParam("categroy_name") @ApiParam("分类名字：不能重复") String categroy_name) {
        try {
            categoryService.addGoodsCategory(categroy_name, DateUtil.currentTime());
            return ResponseEntity.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.of(RC_GOODS_CATEGROY_REPEAT);
        }
    }

    /**
     * 删除分类
     *
     * @param category_id
     */
    @ApiOperation("删除分类")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity deleteGoodsCategory(@RequestParam("category_id") @ApiParam("分类id") String category_id) {
        categoryService.deleteGoodsCategory(category_id);
        return ResponseEntity.success(null);
    }


    /**
     * 查询所有的分类
     *
     * @return
     */
    @ApiOperation("查询分类")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity queryGoodsCategory(@RequestParam("page_index") @ApiParam("当前页") int pageIndex, @RequestParam("pageSize") @ApiParam("当前页数据个数") int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<GoodsCategoryEntity> goodsCategoryEntities = categoryService.queryAllGoodsCategory();
        return ResponseEntity.success(PageUtiil.getPageData(goodsCategoryEntities));
    }
}

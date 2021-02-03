package com.aike.xky.as_api.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/3 11:53 上午
 */
public class PageUtiil {

    public static <T>Map<String,Object> getPageData(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        HashMap<String,Object> data = new HashMap<>();
        data.put("total",pageInfo.getTotal());
        data.put("totalPage",pageInfo.getPages());
        data.put("pageSize",pageInfo.getPageSize());
        data.put("pageIndex",pageInfo.getPageNum());
        data.put("list",list);
        return data;
    }
}

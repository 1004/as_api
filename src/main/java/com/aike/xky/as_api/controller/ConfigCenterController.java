package com.aike.xky.as_api.controller;

import com.aike.xky.as_api.entity.ConfigCenterEntity;
import com.aike.xky.as_api.entity.base.ResponseEntity;
import com.aike.xky.as_api.service.ConfigCenterService;
import com.aike.xky.as_api.utils.ConfigCenterFileUtils;
import com.aike.xky.as_api.utils.PageUtiil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aike.xky.as_api.entity.base.ResponseCode.RC_CONFIG_INVALID;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/2/20 3:02 下午
 */
@RestController
@RequestMapping("/config")
@Api(tags = {"ConfigCenter"})
public class ConfigCenterController {
    @Autowired
    private ConfigCenterService centerService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity queryByNamespace(@RequestParam(value = "name_space", required = false) String nameSpace
            , @RequestParam(value = "page_size", defaultValue = "10") int pageSize
            , @RequestParam(value = "page_index", defaultValue = "1") int pageIndex) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ConfigCenterEntity> configCenterEntities = null;
        if (nameSpace == null || nameSpace.isEmpty()) {
            configCenterEntities = centerService.queryNewAll();
        } else {
            configCenterEntities = centerService.queryByNameSpace(nameSpace);
        }
        return ResponseEntity.success(PageUtiil.getPageData(configCenterEntities));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity upDataConfig(@RequestParam(value = "name_space") String nameSpace
            , @RequestParam(value = "content") String content) {
        if (StringUtil.isEmpty(nameSpace) || StringUtil.isEmpty(content)) {
            return ResponseEntity.of(RC_CONFIG_INVALID);
        }
        ConfigCenterEntity entity = ConfigCenterEntity.of(nameSpace, content);
        //上传内容信息到cdn，供后续客户端下载
        ConfigCenterFileUtils.saveContent(entity);
        centerService.saveConfig(entity);
        return ResponseEntity.success(null);
    }


}

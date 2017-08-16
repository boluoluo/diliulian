/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.diliulian.platform.service.data;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.data.BasicInfoEntity;
import com.diliulian.platform.entity.pub.ManagerEntity;
import com.github.pagehelper.PageInfo;

public interface BasicInfoService {
    BasicInfoEntity selectByAccount(String account);

    public BasicInfoEntity selectByPrimaryKey(Long key);

    PageInfo<JSONObject> queryBasicInfoForList(DataGrid grid, String name);

    AjaxJson batchDelete(Long[] ids);

    AjaxJson save(BasicInfoEntity dto);

    void update(BasicInfoEntity dto);
}

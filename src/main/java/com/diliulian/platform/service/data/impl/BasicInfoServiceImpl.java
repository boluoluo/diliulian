/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.diliulian.platform.service.data.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.data.BasicInfoEntity;
import com.diliulian.platform.mapper.data.BasicInfoMapper;
import com.diliulian.platform.service.BaseService;
import com.diliulian.platform.service.data.BasicInfoService;
import com.diliulian.util.PasswordHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class BasicInfoServiceImpl extends BaseService<BasicInfoEntity> implements BasicInfoService {
    @Autowired
    BasicInfoMapper basicInfoMapper;

    @Override
    public BasicInfoEntity selectByAccount(String account) {
        Example example = new Example(BasicInfoEntity.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account", account);
        List<BasicInfoEntity> list = this.basicInfoMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public BasicInfoEntity selectByPrimaryKey(Long key) {
        return this.basicInfoMapper.selectByPrimaryKey(key);
    }


    @Override
    public PageInfo<JSONObject> queryBasicInfoForList(DataGrid grid, String name) {
        if (StringUtils.isNotEmpty(grid.getSort())) {
            PageHelper.orderBy(grid.getSort() + "   " + grid.getOrder());
        }
        PageHelper.startPage(grid.getPageNum(), grid.getPageSize());
        return new PageInfo<JSONObject>(this.basicInfoMapper.queryManagerForList(name));
    }

    @Override
    public AjaxJson batchDelete(Long[] ids) {
        AjaxJson ajaxJson = new AjaxJson();
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                this.basicInfoMapper.deleteByPrimaryKey(ids[i]);
            }
        }
        ajaxJson.setSuccess(true);
        ajaxJson.setMsg("删除成功！");
        return ajaxJson;
    }

    @Override
    public AjaxJson save(BasicInfoEntity dto) {
        AjaxJson json = new AjaxJson();
        PasswordHelper helper = new PasswordHelper();
        this.basicInfoMapper.updateByPrimaryKeySelective(dto);
        json.setSuccess(true);
        json.setMsg("保存成功！");
        return json;
    }

    @Override
    public void update(BasicInfoEntity dto) {
        this.basicInfoMapper.updateByPrimaryKeySelective(dto);
    }

}

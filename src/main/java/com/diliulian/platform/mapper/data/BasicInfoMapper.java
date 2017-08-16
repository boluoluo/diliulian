/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.diliulian.platform.mapper.data;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.data.BasicInfoEntity;
import com.diliulian.platform.entity.pub.ManagerEntity;

import tk.mybatis.mapper.common.Mapper;

public interface BasicInfoMapper extends Mapper<BasicInfoEntity>
{
	List<JSONObject> queryManagerForList(@Param("name") String name);
	void update(BasicInfoEntity dto);
}

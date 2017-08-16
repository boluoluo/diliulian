package com.diliulian.platform.service.pub;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.pub.ManagerEntity;
import com.github.pagehelper.PageInfo;

public interface ManagerService
{
	ManagerEntity selectByAccount(String account);

	public ManagerEntity selectByPrimaryKey(Long key);

	PageInfo<JSONObject> queryManagerForList(DataGrid grid,String name);

	AjaxJson batchDelete(Long[] ids);

	AjaxJson save(ManagerEntity dto);

	void update(ManagerEntity dto);
}

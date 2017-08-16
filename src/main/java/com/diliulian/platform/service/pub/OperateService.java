package com.diliulian.platform.service.pub;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.pub.OperateEntity;
import com.github.pagehelper.PageInfo;

public interface OperateService
{
	OperateEntity findByOperate(OperateEntity entity);
	PageInfo<JSONObject> queryOperateForList(DataGrid grid);
	Boolean checkPermission(Integer menu,String op, Integer accountid);
	List<OperateEntity> getOperatesInPermissionByMenu(Integer menuid,Integer accountid);
	AjaxJson save(OperateEntity opt);
	AjaxJson deleteByOperate(String[] ids);
}

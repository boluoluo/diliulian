package com.diliulian.platform.service.pub;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.pub.ManagerEntity;
import com.diliulian.platform.entity.pub.MenuEntity;
import com.diliulian.util.TreeNode;
import com.github.pagehelper.PageInfo;

public interface MenuService
{
	public List<JSONObject> queryAllUrlForList();
	List<String> queryPermissionForList(Long userId);
	public List<TreeNode> listTree(ManagerEntity manager);
	public PageInfo<MenuEntity> queryForDataGrid(DataGrid grid);
	public List<MenuEntity> queryMenuByUserId(Long userId);
	public List<JSONObject> getAll();
	public MenuEntity findMenuByPrimaryKey(Integer key);
	AjaxJson saveOrUpdate(MenuEntity entity);
	AjaxJson batchDeleteMenu(Integer[] ids);
}

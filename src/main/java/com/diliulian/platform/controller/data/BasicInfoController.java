/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.diliulian.platform.controller.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.controller.BaseController;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.pub.ManagerEntity;
import com.diliulian.platform.service.pub.ManagerService;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/data/basicinfo")
@ApiIgnore
public class BasicInfoController extends BaseController
{
	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "/list")
	public String list(Model model)
	{
		return "data/basicinfo/list";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long id, Model model)
	{
		if (id != null)
		{
			model.addAttribute("dto", this.managerService.selectByPrimaryKey(id));
		}
		return "data/basicinfo/edit";
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public PageInfo<JSONObject> query(DataGrid grid,String name)
	{
		return this.managerService.queryManagerForList(grid,name);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public AjaxJson save(@ModelAttribute(value = "dto") ManagerEntity dto) throws Exception
	{
		return this.managerService.save(dto);
	}

	@RequestMapping(value = "/remove")
	@ResponseBody
	public AjaxJson del(Long[] ids)
	{
		return this.managerService.batchDelete(ids);
	}


}

package com.diliulian.platform.service.pub.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.pub.ManagerEntity;
import com.diliulian.platform.mapper.pub.ManagerMapper;
import com.diliulian.platform.service.BaseService;
import com.diliulian.platform.service.pub.ManagerService;
import com.diliulian.util.PasswordHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class ManagerServiceImpl extends BaseService<ManagerEntity> implements ManagerService
{
	@Autowired
	ManagerMapper managerMapper;

	@Override
	public ManagerEntity selectByAccount(String account)
	{
		Example example = new Example(ManagerEntity.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("account", account);
		List<ManagerEntity> list = this.managerMapper.selectByExample(example);
		if (list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}

	@Override
	public ManagerEntity selectByPrimaryKey(Long key)
	{
		return this.managerMapper.selectByPrimaryKey(key);
	}

	@Override
	public PageInfo<JSONObject> queryManagerForList(DataGrid grid, String name)
	{
		if (StringUtils.isNotEmpty(grid.getSort()))
		{
			PageHelper.orderBy(grid.getSort() + "   " + grid.getOrder());
		}
		PageHelper.startPage(grid.getPageNum(), grid.getPageSize());
		return new PageInfo<JSONObject>(this.managerMapper.queryManagerForList(name));
	}

	@Override
	public AjaxJson batchDelete(Long[] ids)
	{
		AjaxJson ajaxJson = new AjaxJson();
		if (ids != null && ids.length > 0)
			for (int i = 0; i < ids.length; i++)
			{
				this.managerMapper.deleteByPrimaryKey(ids[i]);
			}
		ajaxJson.setSuccess(true);
		ajaxJson.setMsg("删除成功！");
		return ajaxJson;
	}

	@Override
	public AjaxJson save(ManagerEntity dto)
	{
		AjaxJson json = new AjaxJson();
		PasswordHelper helper = new PasswordHelper();
		if (dto.getManagerid() == null)
		{
			helper.encryptPassword(dto);
			this.managerMapper.insertSelective(dto);
		} else
		{
			if (StringUtils.isNotEmpty(dto.getPassword()))
			{
				helper.encryptPassword(dto);
			} else
			{
				dto.setPassword(null);
			}
			this.managerMapper.updateByPrimaryKeySelective(dto);
		}
		json.setSuccess(true);
		json.setMsg("保存成功！");
		return json;
	}

	@Override
	public void update(ManagerEntity dto)
	{
		this.managerMapper.updateByPrimaryKeySelective(dto);
	}

}

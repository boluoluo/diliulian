package com.diliulian.platform.service.quartz;

import org.quartz.SchedulerException;

import com.diliulian.platform.entity.AjaxJson;
import com.diliulian.platform.entity.DataGrid;
import com.diliulian.platform.entity.quartz.ScheduleJobEntity;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: ScheduleJobService
 * @Description:
 * @author 唐亚峰
 * @date 2016年11月18日
 */
public interface ScheduleJobService
{
	PageInfo<ScheduleJobEntity> queryScheduleJobForList(DataGrid grid);
	ScheduleJobEntity selectByPrimaryKey(Integer id);
	AjaxJson saveOrUpdate(ScheduleJobEntity entity) throws SchedulerException;
	AjaxJson updateJobState(Integer id,String cmd) throws SchedulerException;
}

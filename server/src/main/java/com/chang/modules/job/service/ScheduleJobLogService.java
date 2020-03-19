package com.chang.modules.job.service;

import com.baomidou.mybatisplus.service.IService;
import com.chang.common.utils.PageUtils;
import com.chang.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 * @since 1.2.0 2016-11-28
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}

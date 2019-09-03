package com.chang.modules.oss.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chang.common.util.Query;
import com.chang.common.utils.PageUtils;
import com.chang.modules.oss.dao.SysOssDao;
import com.chang.modules.oss.service.SysOssService;
import com.chang.modules.oss.entity.SysOssEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SysOssEntity> page = this.selectPage(
				new Query<SysOssEntity>(params).getPage()
		);

		return new PageUtils(page);
	}
	
}

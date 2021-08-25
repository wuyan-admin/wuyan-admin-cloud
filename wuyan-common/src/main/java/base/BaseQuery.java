/*
 * Copyright (c) 2020, wangguodong194@163.com. All rights reserved.
 */

package base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.core.base.BaseVo
 * @description
 * @date 2020-05-28
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Data
public class BaseQuery implements Serializable {
	/**
	 * 总数
	 */
	protected long total = 0;
	/**
	 * 每页显示条数，默认 10
	 */
	protected long size = 10;
	/**
	 * 当前页
	 */
	protected long current = 1;

	public IPage toPage() {
		return new Page(this.getCurrent(), this.getSize());
	}
}

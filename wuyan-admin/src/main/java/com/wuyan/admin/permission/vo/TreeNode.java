/*
 * Copyright (c) 2020, wangguodong194@163.com. All rights reserved.
 */

package com.wuyan.admin.permission.vo;

import lombok.Data;

import java.util.List;

/**
 * @author mrwang
 * @version V1.0
 * @file com.springboot.admin.business.system.sysPermission.vo.TreeNode
 * @description
 * @date 2020-06-04
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Data
public class TreeNode {

	private Long key;

	private String title;

	private Boolean disabled;

	private List<TreeNode> children;
}

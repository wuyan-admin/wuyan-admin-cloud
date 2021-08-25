package com.wuyan.admin.permission.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.wuyan.admin.permission.entity.SysPermission;
import com.wuyan.admin.permission.enums.SystemEnum;
import com.wuyan.admin.permission.mapper.SysPermissionMapper;
import com.wuyan.admin.permission.service.SysPermissionService;
import com.wuyan.admin.permission.vo.SysPermissionVo;
import com.wuyan.admin.permission.vo.TreeNode;
import com.wuyan.admin.role.entity.SysRolePermission;
import com.wuyan.admin.role.service.SysRolePermissionService;
import com.wuyan.admin.user.entity.SysUser;
import com.wuyan.admin.user.entity.SysUserRole;
import com.wuyan.admin.user.service.SysUserRoleService;
import enums.AssertEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wangguodong194@163.com
 * @since 2020-05-02
 */
@Service
@AllArgsConstructor
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {


	private final SysUserRoleService sysUserRoleService;

	private final SysRolePermissionService sysRolePermissionService;


	@Override
	public List<SysPermissionVo> getMenu(SysUser sysUser) {
		// 查询单个菜单 筛选类型是菜单的数据
		List<SysPermissionVo> list = this.getPermissionIds(sysUser)
				.stream()
				.filter(item -> item.getPermissionType().equals(SystemEnum.MENU.getValue()))
				.collect(Collectors.toList());
		return this.joinMenu(list);
	}

	@Override
	public List<SysPermissionVo> getPermissionList(SysUser sysUser) {
		// 查询单个菜单 筛选类型是操作的数据
		return this.getPermissionIds(sysUser).stream().filter(item -> item.getPermissionType().equals(SystemEnum.ACTION.getValue())).collect(Collectors.toList());
	}

	@Override
	public IPage<SysPermissionVo> getPageList(SysPermissionVo vo) {
		IPage<SysPermission> page = this.page(vo.toPage());
		return page.convert(SysPermissionVo::create);
	}

	@Override
	public List<TreeNode> treeList(SysUser sysUser) {
		List<SysPermissionVo> permissionVoList = this.joinMenu(this.getPermissionIds(sysUser));
		List<TreeNode> nodeList = permissionVoList.stream().map((item) -> {
			TreeNode node = new TreeNode();
			node.setKey(item.getId());
			node.setTitle(item.getPermissionName());
			copyTreeNode(item.getChildren(), node);
			return node;
		}).collect(Collectors.toList());
		return nodeList;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean update(SysPermission sysPermission) {
		Assert.notNull(sysPermission.getId(), AssertEnum.NOT_NULL.getValue());
		SysPermission version = this.getById(sysPermission.getId());
		sysPermission.setVersion(version.getVersion());
		return this.updateById(sysPermission);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean delete(SysPermission sysPermission) {
		Assert.notNull(sysPermission.getId(), AssertEnum.NOT_NULL.getValue());
		// 删除菜单
		this.removeById(sysPermission);
		// 删除角色和菜单关联关系
		return sysRolePermissionService.deleteByPermissionId(sysPermission.getId());
	}

	@Override
	public List<SysPermissionVo> getPermissionByRoleId(Long roleId) {
		Assert.notNull(roleId, AssertEnum.NOT_NULL.getValue());
		// 查询所有的菜单
		List<SysPermissionVo> permissions =
				sysRolePermissionService.
						list(Wrappers.<SysRolePermission>lambdaQuery()
								.eq(SysRolePermission::getRoleId, roleId)).stream().map(item ->
						this.getById(item.getPermissionId())
				).map(item -> {
					SysPermissionVo vo = new SysPermissionVo();
					BeanUtils.copyProperties(item, vo);
					return vo;
				}).collect(Collectors.toList());
		return permissions;
	}

	@Override
	public List<SysPermissionVo> getTagPermissionByRoleId(Long roleId) {
		// 获取所有的菜单
		List<SysPermissionVo> permissions = this.getPermissionByRoleId(roleId);
		// 菜单
		List<SysPermissionVo> menus = permissions.stream()
				.filter(item -> item.getPermissionType().equals(SystemEnum.MENU.getValue()))
				.collect(Collectors.toList());
		// 排序
		menus.sort(Comparator.comparing(SysPermissionVo::getDisplayOrder));
		// 权限
		List<SysPermissionVo> permission = permissions.stream().filter(child -> child.getPermissionType().equals(SystemEnum.ACTION.getValue())).collect(Collectors.toList());
		// 把权限分类
		List<SysPermissionVo> res = menus.stream().map(item -> {
			List<SysPermissionVo> children = permission.stream().filter(child -> child.getParentId().equals(item.getId())).collect(Collectors.toList());
			item.setChildren(children);
			return item;
		}).collect(Collectors.toList());
		return res;
	}

	/**
	 * 组装树子节点
	 *
	 * @param permissionVoList
	 * @param treeNode
	 */
	private void copyTreeNode(List<SysPermissionVo> permissionVoList, TreeNode treeNode) {
		if (!CollectionUtils.isEmpty(permissionVoList)) {
			treeNode.setChildren(permissionVoList.stream().map(item -> {
				TreeNode node = new TreeNode();
				node.setKey(item.getId());
				node.setTitle(item.getPermissionName());
				copyTreeNode(item.getChildren(), node);
				return node;
			}).collect(Collectors.toList()));
		}
	}


	/**
	 * 获取权限id集合
	 *
	 * @param sysUser 用户
	 * @return
	 */
	public List<SysPermissionVo> getPermissionIds(SysUser sysUser) {
		List<SysPermission> permissions = Lists.newArrayList();
		// 管理员查询所有菜单
		if (sysUser.getIsAdmin()) {
			permissions = this.list();
		} else {
			// 查询用户拥有的角色
			List<Long> roles = sysUserRoleService.
					list(Wrappers.<SysUserRole>lambdaQuery()
							.eq(SysUserRole::getUserId, sysUser.getId())).stream().map(v -> v.getRoleId()).collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(roles)) {
				// 查询角色下的菜单
				permissions = sysRolePermissionService.
						list(Wrappers.<SysRolePermission>lambdaQuery()
								.in(SysRolePermission::getRoleId, roles)).stream().map(item ->
						this.getById(item.getPermissionId())
				).collect(Collectors.toList());
			}
		}

		return permissions.stream().map(item -> {
			SysPermissionVo vo = new SysPermissionVo();
			BeanUtils.copyProperties(item, vo);
			return vo;
		}).collect(Collectors.toList());
	}

	/**
	 * 组装菜单子父级关系 并进行排序
	 *
	 * @param list
	 * @return
	 */
	public List<SysPermissionVo> joinMenu(List<SysPermissionVo> list) {
		// 把结果转换成map
		Map<Long, SysPermissionVo> map = list.stream().collect(Collectors.toMap(SysPermissionVo::getId, v -> v));
		// 存在父级元素就把当前元素放入父级元素中
		map.forEach((k, v) -> {
			Long pId = v.getParentId();
			SysPermissionVo pVo = map.get(pId);
			if (null != pVo) {
				if (null != pVo.getChildren()) {
					pVo.getChildren().add(v);
				} else {
					List<SysPermissionVo> children = Lists.newArrayList();
					children.add(v);
					pVo.setChildren(children);
				}
			}
		});
		// 对子级元素进行排序
		map.forEach((k, v) -> {
			if (null != v.getChildren() && v.getChildren().size() > 1) {
				v.setChildren(v.getChildren().stream().sorted(Comparator.comparingInt(SysPermissionVo::getDisplayOrder)).collect(Collectors.toList()));
			}
		});
		// 筛选顶级菜单并对其排序
		return map.values().stream().filter(v -> v.getParentId() == 0).sorted(Comparator.comparingInt(SysPermissionVo::getDisplayOrder)).collect(Collectors.toList());
	}
}

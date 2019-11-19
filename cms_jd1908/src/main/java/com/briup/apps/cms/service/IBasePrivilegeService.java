package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

public interface IBasePrivilegeService {
	//查看所有权限
	List<BasePrivilege> findAll();
	//通过ParentId查看权限
	List<BasePrivilege> findByParentId(Long parentId);
	//保存或更新权限
	void saveOrUpdate(BasePrivilege privilege) throws CustomerException;
	//查询权限树
	List<PrivilegeTree> findPrivilegeTree();
	//查询用户所有权限
	List<BasePrivilege> findByUserId(long id);
	
}

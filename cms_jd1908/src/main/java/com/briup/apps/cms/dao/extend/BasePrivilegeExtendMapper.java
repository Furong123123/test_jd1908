package com.briup.apps.cms.dao.extend;
//权限管理

import java.util.List;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.vm.PrivilegeTree;

public interface BasePrivilegeExtendMapper {
	List<PrivilegeTree> selectAll();
	
	List<BasePrivilege> selectByParentId(long id);
	
	List<BasePrivilege> selectByRoleId(long id);
	
	List<BasePrivilege> selectByUserId(long id);
	
}

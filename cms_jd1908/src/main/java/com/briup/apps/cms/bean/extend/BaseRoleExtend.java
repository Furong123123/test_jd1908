package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BaseRole;

public class BaseRoleExtend extends BaseRole{
	private List<BasePrivilege> privileges;

	public List<BasePrivilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<BasePrivilege> privileges) {
		this.privileges = privileges;
	}
	
	
}

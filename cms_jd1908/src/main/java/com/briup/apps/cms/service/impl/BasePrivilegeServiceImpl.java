package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BasePrivilegeExample;
import com.briup.apps.cms.dao.BasePrivilegeMapper;
import com.briup.apps.cms.dao.extend.BasePrivilegeExtendMapper;
import com.briup.apps.cms.service.IBasePrivilegeService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

@Service
public class BasePrivilegeServiceImpl implements IBasePrivilegeService{

	@Resource
	private BasePrivilegeMapper basePrivateMapper;
	@Resource
	private BasePrivilegeExtendMapper basePrivilegeExtendMapper;
	@Override
	public List<BasePrivilege> findAll() {
		return basePrivateMapper.selectByExample(new BasePrivilegeExample());
	}

	@Override
	public List<BasePrivilege> findByParentId(Long parentId) {
		BasePrivilegeExample example = new BasePrivilegeExample();
		if(parentId == null) {
			example.createCriteria().andParentIdIsNull();
		}else {
			example.createCriteria().andParentIdEqualTo(parentId);
		}
		return basePrivateMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(BasePrivilege privilege) throws CustomerException {
		if(privilege.getId() != null) {
			basePrivateMapper.updateByPrimaryKey(privilege);
		}else {	
			basePrivateMapper.insert(privilege);
		}
		
	}

	@Override
	public List<PrivilegeTree> findPrivilegeTree() {

		return basePrivilegeExtendMapper.selectAll();
	}

	@Override
	public List<BasePrivilege> findByUserId(long id) {
		
		return basePrivilegeExtendMapper.selectByUserId(id);
	}

}

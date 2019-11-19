package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.BaseRoleExample;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.dao.BaseRoleMapper;
import com.briup.apps.cms.dao.extend.BaseRoleExtendMapper;
import com.briup.apps.cms.service.IBaseRoleService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class BaseRoleServiceImpl implements IBaseRoleService{
	@Resource
	private BaseRoleMapper baseRoleMapper;
	@Resource
	private BaseRoleExtendMapper baseRoleExtendMapper;
	
	@Override
	public void authorization(long roleId, List<Long> privilegeIds) {
		
	}

	@Override
	public List<BaseRole> findAll() {
		
		return baseRoleMapper.selectByExample(new BaseRoleExample());
	}

	@Override
	public List<BaseRoleExtend> cascadePrivilegeFindAll() {
		
		return baseRoleExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(BaseRole baseRole) throws CustomerException {
		if(baseRole.getId() != null) {
			baseRoleMapper.updateByPrimaryKeySelective(baseRole);
		}else {
			baseRoleMapper.insert(baseRole);
		}
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		BaseRole role = baseRoleMapper.selectByPrimaryKey(id);
		if(role == null) {
			throw new CustomerException("要删除的角色不存在！");
		}
		baseRoleMapper.deleteByPrimaryKey(id);
	}

}

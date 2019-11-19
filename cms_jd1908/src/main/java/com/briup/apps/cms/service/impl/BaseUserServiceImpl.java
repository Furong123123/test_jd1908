package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.BaseUserExample;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.dao.BaseRoleMapper;
import com.briup.apps.cms.dao.BaseUserMapper;
import com.briup.apps.cms.dao.extend.BaseUserExtendMapper;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;
@Service
public class BaseUserServiceImpl implements IBaseUserService{
	@Resource
	private BaseUserMapper baseUserMapper;
	@Resource
	private BaseRoleMapper baseRoleMapper;
	@Resource
	private BaseUserExtendMapper baseUserExtendMapper;
	@Override
	public BaseUser login(UserVM userVM) throws CustomerException {
		return null;
	}

	@Override
	public BaseUserExtend findById(long id) {
		
		return baseUserExtendMapper.selectById(id);
	}

	@Override
	public List<BaseUser> findAll() {
	
		return baseUserMapper.selectByExample(new BaseUserExample());
	}

	@Override
	public List<BaseUserExtend> cascadeRoleFindAll() {
		return baseUserExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
		if(baseUser.getId() != null) {
			baseUserMapper.updateByPrimaryKey(baseUser);
		}else {
			//判断用户名是否被占用
			BaseUserExample example = new BaseUserExample();
			example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
			List<BaseUser> list = baseUserMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("该用户已经被占用");
			}
			//初始化
			baseUser.setRegisterTime(new Date().getTime());
			baseUser.setStatus(BaseUserExtend.STATUS_NORMAL);
			baseUserMapper.insert(baseUser);
		}
		
	}

	@Override
	public void changeStatus(long id, String status) throws CustomerException {
		BaseUser user= this.findById(id);
		if(user == null) {
			throw new CustomerException("该用户不存在");
		}
		user.setStatus(status);
		baseUserMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		BaseUser user = this.findById(id);
		if(user == null) {
			throw new CustomerException("该用户不存在");
		}
		baseUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void setRoles(long id, List<Long> roles) {
		// TODO Auto-generated method stub
		
	}

}

package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.CustomerException;

//栏目管理
public interface ICategoryService {
	
	List<Category> findAll();
	
	//更新保存(基本数据)
	void saveOrUpdate(Category category) throws CustomerException;
	//删除
	void deleteById(long id) throws CustomerException;
	//批量删除
	void batchDelete(long[] ids) throws CustomerException;
}

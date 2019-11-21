package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IArticleService {
	List<Article> findAll();
	
	
	List<ArticleExtend> cascadeFindAll();
	
	ArticleExtend findById(long id);
	
	//更新保存(基本数据)
	void saveOrUpdate(Article article) throws CustomerException;
	//删除
	void deleteById(long id) throws CustomerException;
}

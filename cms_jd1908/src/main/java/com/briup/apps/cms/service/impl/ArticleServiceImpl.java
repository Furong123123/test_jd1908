package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;
@Service
public class ArticleServiceImpl implements IArticleService{
	
	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	@Override
	public List<Article> findAll() {
		
		return articleMapper.selectByExample(new ArticleExample());
	}

	@Override
	public void saveOrUpdate(Article article) throws CustomerException{
		if(article.getId() != null) {
			articleMapper.updateByPrimaryKey(article);
		}else {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("文章标题不能重复");
			}
			 // 初始化
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpDown(0l);
            article.setThumpUp(0l);
            articleMapper.insert(article);
		}
	}

	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return articleExtendMapper.selectAll();
	}

	@Override
	public ArticleExtend findById(long id) {
		return articleExtendMapper.selectById(id);
	}

	@Override
	public void deleteById(long id) {
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article == null) {
			throw new CustomerException("标题不存在");
		}else {
		articleMapper.deleteByPrimaryKey(id);
		}
}
	}



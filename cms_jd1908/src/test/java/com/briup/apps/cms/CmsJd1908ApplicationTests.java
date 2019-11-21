package com.briup.apps.cms;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.dao.ArticleMapper;

@SpringBootTest
class CmsJd1908ApplicationTests {

	@Autowired
	ArticleMapper am ;
	
	@Test
	void contextLoads() {
		List<Article> selectByExample = am.selectByExample(new ArticleExample());
		
		  Article a = new Article(); a.setTitle("测试文章222"); am.insert(a);
		 
		System.out.println(selectByExample.get(0).getTitle());
		
	}

}

package com.briup.apps.cms.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private IArticleService articleService;
	
	@GetMapping(value = "findAll")
	public Message findAll() {
		List<Article> list = articleService.findAll();
		return MessageUtil.success(list);
	}
	
	@GetMapping(value = "cascadeFindAll")
	public Message selectAll(){
		List<ArticleExtend> list = articleService.cascadeFindAll();
		System.out.println(list.get(0).getTitle());
		return MessageUtil.success(list);
	}
	
	@GetMapping(value = "findById")
	public Message findById(long id){
		ArticleExtend articleExtend = articleService.findById(id);
		return MessageUtil.success(articleExtend);
	}
	@ApiOperation("保存或更新")
	 @ApiImplicitParams({
         @ApiImplicitParam(name = "id", value = "编号",paramType = "form",required = false),
         @ApiImplicitParam(name = "title", value = "标题",paramType = "form",required = true),
         @ApiImplicitParam(name = "content", value = "内容",paramType = "form",required = true),
         @ApiImplicitParam(name = "source", value = "源内容",paramType = "form",required = false),
         @ApiImplicitParam(name = "categoryId", value = "所属栏目id",paramType = "form",required = true),
         @ApiImplicitParam(name = "authorId", value = "所属作者id",paramType = "form",required = false)
    })
	@PostMapping("saveOrUpdate")
	public Message saveOrUdate( Long id,
            @NotNull String title,
            @NotNull String content,
            String source,
            @NotNull long categoryId,
            Long authorId) {
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setSource(source);
		article.setCategoryId(categoryId);
		article.setAuthorId(authorId);
		articleService.saveOrUpdate(article);
		return MessageUtil.success("更新成功");
	}
	@ApiOperation("通过id删除")
	@ApiImplicitParams(@ApiImplicitParam(name = "id",value = "编号",required = true))
	@GetMapping("/deleteById")
	public Message deleteById(Long id) {
		articleService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
}

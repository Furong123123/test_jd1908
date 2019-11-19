package com.briup.apps.cms.web.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserVM;

import io.swagger.annotations.ApiOperation;

/**
 * 用户控制器
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IBaseUserService baseUserService;
	@ApiOperation(value = "用户登录")
	@PostMapping("/login")
	public Message login(@RequestBody UserVM userVM) {
		 // 1. 认证用户的用户名和密码
		 // 2. 如果登录成功产生token,将token缓存起来，返回
		 // 3. 如果登录失败
		HashMap<String, String> map = new HashMap<>();
		map.put("token", "admin-token");
		return MessageUtil.success(map);
	}
	
	@ApiOperation(value = "通过token获取用户信息")
	@GetMapping("/info")
	public Message info(String token) {
		//通过token获取用户信息{id user gender roles:[]}
		return MessageUtil.success("登录成功");
	}
	
	@ApiOperation(value = "退出")
	@PostMapping("/logout")
	public Message logout() {
		// 1. 登录， token从缓存中移除掉
		return MessageUtil.success("退出成功");
	}
	
}

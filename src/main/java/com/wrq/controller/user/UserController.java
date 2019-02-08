package com.wrq.controller.user;

import javax.validation.Valid;

import com.wrq.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrq.vo.UserVo;
import com.wrq.service.user.IUserService;
import com.wrq.commons.ServerResponse;

/**
 * todo:用户Controller控制器类
 * UserController 
 * 作者:王瑞乾 
 * 创建时间：2019年02月03日 16:01:41  
 * @version 1.0.0 
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/user")
	public String userindex() {
		return "user/index";
	}

	@GetMapping("/user/{id}")
	public String userdetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "user/detail";
	}
	
	
	@PostMapping("/user/template")
	public String template(UserVo userVo,ModelMap map) {
		ServerResponse serverResponse = userService.queryUserAll(userVo);
		map.addAttribute("pages", serverResponse.getData());
		return "user/template";
	}
	
	
	@ResponseBody
	@GetMapping("/user/get/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	
	@ResponseBody
	@PostMapping("/user/save")
	public ServerResponse saveUser(@Valid UserVo userVo) {
		return userService.saveUser(userVo);
	}
	
	@ResponseBody
	@PostMapping("/user/update")
	public ServerResponse updateUser(@Valid UserVo userVo) {
		return userService.updateUser(userVo);
	}
	
	
	@ResponseBody
	@PostMapping("/user/delete/{id}")
	public ServerResponse deleteUser(@PathVariable("id") Integer id) {
		return userService.deleteUserById(id);
	}
	
}

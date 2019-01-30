package com.wrq.controller.blog;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrq.vo.BlogVo;
import com.wrq.service.blog.IBlogService;
import com.wrq.commons.ServerResponse;

/**
 * 
 * 博客Controller控制器类
 * 作者:王瑞乾
 * 创建时间：2019年01月30日 10:38:33
 * @version 1.0.0
 *
 */
@Controller
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	@GetMapping("/blog")
	public String blogIndex() {
		return "blog/index";
	}

	@GetMapping("/blog/{id}")
	public String blogDetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "blog/detail";
	}
	
	
	@PostMapping("/blog/template")
	public String template(BlogVo blogVo,ModelMap map) {
		ServerResponse serverResponse = blogService.queryBlogAll(blogVo);
		map.addAttribute("pages", serverResponse.getData());
		return "blog/template";
	}
	
	
	@ResponseBody
	@GetMapping("/blog/get/{id}")
	public ServerResponse getBlog(@PathVariable("id") Integer id) {
		return blogService.getBlogById(id);
	}
	
	
	@ResponseBody
	@PostMapping("/blog/save")
	public ServerResponse saveBlog(@Valid BlogVo blogVo) {
		return blogService.saveBlog(blogVo);
	}
	
	@ResponseBody
	@PostMapping("/blog/update")
	public ServerResponse updateBlog(@Valid BlogVo blogVo) {
		return blogService.updateBlog(blogVo);
	}
	
	
	@ResponseBody
	@PostMapping("/blog/delete/{id}")
	public ServerResponse deleteBlog(@PathVariable("id") Integer id) {
		return blogService.deleteBlogById(id);
	}
	
}

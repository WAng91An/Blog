package com.wrq.controller.blog;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.wrq.vo.BlogVo;
import com.wrq.service.blog.IBlogService;
import com.wrq.commons.ServerResponse;

/**
 * 博客Controller控制器类
 * 作者:王瑞乾
 * 创建时间：2019年01月30日 10:38:33
 * @version 1.0.0
 */
@Controller
@Slf4j
public class BlogController {
	
	@Autowired
	private IBlogService blogService;

	/**
	 * 跳转首页
	 * @return
     */
	@GetMapping("/blog")
	public String blogIndex() {
		return "index";
	}

	/**
	 * 博客列表接口，分页
	 * @param pageNum
	 * @param pageSize
     * @return
     */
	@GetMapping("/blog/list")
	@ResponseBody
	public ServerResponse blogList(@RequestParam(value = "pageNum", defaultValue = "0", required = false)Integer pageNum ,
						   @RequestParam(value = "pageSize", defaultValue = "6", required = false)Integer pageSize) {
		log.info("请求了 /blog/list ");
		return blogService.queryBlogs(pageNum, pageSize);
	}

	/**
	 * 根据 id 请求博客详情
	 * @param id 博客的id
	 * @param map ModelMap
     * @return 博客详情
     */
	@GetMapping("/blog/{id}")
	public String blogDetail(@PathVariable("id") Integer id, ModelMap map) {
		ServerResponse detail = blogService.getBlogDetailById(id);
		log.info("请求了 /blog/id ");
		map.addAttribute("detail", detail.getData());
		return "blog/detail";
	}

	/**
	 * 博客详情: 返回 Json 数据
	 * @param id 博客的id
	 * @return 博客详情的Json数据
     */
	@GetMapping("/detail/{id}")
	@ResponseBody
	public ServerResponse detail(@PathVariable("id") Integer id) {
		ServerResponse detail = blogService.getBlogDetailById(id);
		log.info("请求了 /detail/id ");
		return ServerResponse.createBySuccess(detail);
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

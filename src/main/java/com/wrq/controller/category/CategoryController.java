package com.wrq.controller.category;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrq.vo.CategoryVo;
import com.wrq.service.category.ICategoryService;
import com.wrq.commons.ServerResponse;

/**
 * 
 * todo:分类Controller控制器类
 * CategoryController
 * 作者:王瑞乾
 * 创建时间：2019年02月03日 15:55:04
 * @version 1.0.0
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("/category")
	public String categoryindex() {
		return "category/index";
	}

	@GetMapping("/category/{id}")
	public String categorydetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "category/detail";
	}
	
	
	@PostMapping("/category/template")
	public String template(CategoryVo categoryVo,ModelMap map) {
		ServerResponse serverResponse = categoryService.queryCategoryAll(categoryVo);
		map.addAttribute("pages", serverResponse.getData());
		return "category/template";
	}
	
	
	@ResponseBody
	@GetMapping("/category/get/{id}")
	public ServerResponse getCategory(@PathVariable("id") Integer id) {
		return categoryService.getCategoryById(id);
	}
	
	
	@ResponseBody
	@PostMapping("/category/save")
	public ServerResponse saveCategory(@Valid CategoryVo categoryVo) {
		return categoryService.saveCategory(categoryVo);
	}
	
	@ResponseBody
	@PostMapping("/category/update")
	public ServerResponse updateCategory(@Valid CategoryVo categoryVo) {
		return categoryService.updateCategory(categoryVo);
	}
	
	@ResponseBody
	@PostMapping("/category/delete/{id}")
	public ServerResponse deleteCategory(@PathVariable("id") Integer id) {
		return categoryService.deleteCategoryById(id);
	}
	
}

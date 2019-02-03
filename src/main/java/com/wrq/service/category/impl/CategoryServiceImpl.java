package com.wrq.service.category.impl;


import java.util.List;

import com.wrq.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.CategoryMapper;
import com.wrq.vo.CategoryVo;
import com.wrq.pojo.Category;
import com.wrq.commons.ServerResponse;


/**
 * todo:分类Service实现类
 * CategoryServiceImpl<br/>
 * 作者:王瑞乾<br/>
 * 创建时间：2019年02月03日 15:55:04 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public ServerResponse queryCategoryAll(CategoryVo categoryVo){
		PageHelper.startPage(categoryVo.getPageNo(), categoryVo.getPageSize());
		List<Category> categorys = categoryMapper.queryCategoryAll(categoryVo);
		PageInfo<Category> pageInfo = new PageInfo<>(categorys);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveCategory(CategoryVo categoryVo) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryVo, category);
		int count = categoryMapper.saveCategory(category);
		return count>0?ServerResponse.createBySuccess(category):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateCategory(CategoryVo categoryVo) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryVo, category);
		int count = categoryMapper.updateCategory(category);
		return count>0?ServerResponse.createBySuccess(category):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteCategoryById(Integer id) {
		int count = categoryMapper.deleteCategoryById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getCategoryById(Integer id) {
		Category category = categoryMapper.getCategoryById(id);
		return category!=null?ServerResponse.createBySuccess(category):ServerResponse.createByError();
	}
	
	
}

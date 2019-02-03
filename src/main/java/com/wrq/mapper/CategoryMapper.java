package com.wrq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wrq.vo.CategoryVo;
import com.wrq.pojo.Category;

/**
 * todo:分类
 * Category
 * 创建人:王瑞乾
 * 时间：2019年02月03日 15:55:04
 * @version 1.0.0
 *
 */
public interface CategoryMapper {
	//添加
	public int saveCategory(Category category);
	//修改
	public int updateCategory(Category category);
	//删除
	public int deleteCategoryById(@Param("id")Integer id);
	//查询单个
	public Category getCategoryById(@Param("id")Integer id);
	//查询所有
	public List<Category> queryCategoryAll(CategoryVo categoryVo);
}
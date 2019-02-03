package com.wrq.service.category;

import com.wrq.commons.ServerResponse;
import com.wrq.vo.CategoryVo;

public interface ICategoryService {
	
	  ServerResponse saveCategory(CategoryVo categoryVo);
	
	  ServerResponse updateCategory(CategoryVo categoryVo);
	
	  ServerResponse deleteCategoryById(Integer id);
	
	  ServerResponse getCategoryById(Integer id);
	
	  ServerResponse queryCategoryAll(CategoryVo categoryVo);
}

package com.wrq.service.blog;

import com.wrq.commons.ServerResponse;
import com.wrq.vo.BlogVo;

public interface IBlogService {
	
	ServerResponse saveBlog(BlogVo blogVo);
	
	ServerResponse updateBlog(BlogVo blogVo);
	
	ServerResponse deleteBlogById(Integer id);
	
	ServerResponse getBlogById(Integer id);
	
	ServerResponse queryBlogAll(BlogVo blogVo);

	ServerResponse queryBlogs(Integer pageNum, Integer pageSize);

	ServerResponse getBlogDetailById(Integer id);
}

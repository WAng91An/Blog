package com.wrq.service.blog;

import com.wrq.commons.ServerResponse;
import com.wrq.vo.BlogVo;

public interface IBlogService {
	
	public ServerResponse saveBlog(BlogVo blogVo);
	
	public ServerResponse updateBlog(BlogVo blogVo);
	
	public ServerResponse deleteBlogById(Integer id);
	
	public ServerResponse getBlogById(Integer id);
	
	public ServerResponse queryBlogAll(BlogVo blogVo);
}

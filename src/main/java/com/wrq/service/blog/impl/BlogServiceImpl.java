package com.wrq.service.blog.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.BlogMapper;
import com.wrq.pojo.Blog;
import com.wrq.service.blog.IBlogService;
import com.wrq.vo.BlogVo;
import com.wrq.commons.ServerResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 博客Service实现类
 * 作者:王瑞乾
 * 创建时间：2019年01月30日 10:20:28
 * @version 1.0.0
 *
 */
@Service
public class BlogServiceImpl implements IBlogService  {

	@Autowired
	private BlogMapper blogMapper;
	
	public ServerResponse queryBlogAll(BlogVo blogVo){
		PageHelper.startPage(blogVo.getPageNo(), blogVo.getPageSize());
		List<Blog> blogs = blogMapper.queryBlogAll(blogVo);
		PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveBlog(BlogVo blogVo) {
		Blog blog = new Blog();
		BeanUtils.copyProperties(blogVo, blog);
		int count = blogMapper.saveBlog(blog);
		return count>0?ServerResponse.createBySuccess(blog):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateBlog(BlogVo blogVo) {
		Blog blog = new Blog();
		BeanUtils.copyProperties(blogVo, blog);
		int count = blogMapper.updateBlog(blog);
		return count>0?ServerResponse.createBySuccess(blog):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteBlogById(Integer id) {
		int count = blogMapper.deleteBlogById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getBlogById(Integer id) {
		Blog blog = blogMapper.getBlogById(id);
		return blog!=null?ServerResponse.createBySuccess(blog):ServerResponse.createByError();
	}
	
	
}

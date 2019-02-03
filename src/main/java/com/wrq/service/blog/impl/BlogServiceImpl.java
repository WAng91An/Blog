package com.wrq.service.blog.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.BlogMapper;
import com.wrq.mapper.UserMapper;
import com.wrq.pojo.Blog;
import com.wrq.pojo.User;
import com.wrq.service.blog.IBlogService;
import com.wrq.vo.BlogVo;
import com.wrq.commons.ServerResponse;
import com.wrq.vo.DetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

	@Autowired
	private UserMapper userMapper;
	
	public ServerResponse queryBlogAll(BlogVo blogVo){
		PageHelper.startPage(blogVo.getPageNo(), blogVo.getPageSize());
		List<Blog> blogs = blogMapper.queryBlogAll(blogVo);
		PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
		return ServerResponse.createBySuccess(pageInfo);
	}

	/**
	 * 查询首页博客信息，分页插件
	 * @param pageNum
	 * @param pageSize
     * @return
     */
	@Override
	public ServerResponse queryBlogs(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = blogMapper.queryBlogs();
		PageInfo info = new PageInfo(list);
		return ServerResponse.createBySuccess("请求成功", info);
	}

	/**
	 * 根据 id 获得博客详情
	 * @param id
	 * @return
     */
	@Override
	public ServerResponse getBlogDetailById(Integer id) {
		DetailVo blogDetail = blogMapper.getBlogDetailById(id);
		Integer userId = blogDetail.getUserId();
		User user = userMapper.getUserById(userId);
		blogDetail.setUserName(user.getUsername());
		return blogDetail!=null?ServerResponse.createBySuccess("获取成功", blogDetail):ServerResponse.createByError("获取博客详情失败");
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

package com.wrq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wrq.vo.BlogVo;
import com.wrq.pojo.Blog;

/**
 * 
 * todo:博客
 * Blog<br/>
 * 创建人:王瑞乾<br/>
 * 时间：2019年01月30日 10:38:33 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface BlogMapper {
	//添加
	public int saveBlog(Blog blog);
	//修改
	public int updateBlog(Blog blog);
	//删除
	public int deleteBlogById(@Param("id")Integer id);
	//查询单个
	public Blog getBlogById(@Param("id")Integer id);
	//查询所有
	public List<Blog> queryBlogAll(BlogVo blogVo);
}
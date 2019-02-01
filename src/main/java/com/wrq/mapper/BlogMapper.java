package com.wrq.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
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
	int saveBlog(Blog blog);
	//修改
	int updateBlog(Blog blog);
	//删除
	int deleteBlogById(@Param("id")Integer id);
	//查询单个
	Blog getBlogById(@Param("id")Integer id);
	//查询所有
	List<Blog> queryBlogAll(BlogVo blogVo);
	//查询博客首页信息，插件
	List<Map<String, Object>> queryBlogs();
}
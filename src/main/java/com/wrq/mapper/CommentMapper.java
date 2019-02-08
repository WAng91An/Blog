package com.wrq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wrq.vo.CommentVo;
import com.wrq.pojo.Comment;

/**
 * todo:评论
 * Comment
 * 创建人:王瑞乾
 * 时间：2019年02月03日 16:00:08
 * @version 1.0.0
 *
 */
public interface CommentMapper {
	//添加
	int saveComment(Comment comment);
	//修改
	int updateComment(Comment comment);
	//删除
	int deleteCommentById(@Param("id")Integer id);
	//查询单个
	Comment getCommentById(@Param("id")Integer id);
	//查询所有
	List<Comment> queryCommentFirstLevel(@Param("blogId")Integer blogId);
}
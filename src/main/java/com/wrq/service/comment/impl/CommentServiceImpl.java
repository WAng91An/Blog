package com.wrq.service.comment.impl;


import java.util.List;

import com.wrq.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.CommentMapper;
import com.wrq.vo.CommentVo;
import com.wrq.pojo.Comment;
import com.wrq.commons.ServerResponse;


/**
 * todo:评论Service实现类
 * CommentServiceImpl<br/>
 * 作者:王瑞乾<br/>
 * 创建时间：2019年02月03日 16:00:08 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	public ServerResponse queryCommentAll(CommentVo commentVo){
		PageHelper.startPage(commentVo.getPageNo(), commentVo.getPageSize());
		List<Comment> comments = commentMapper.queryCommentAll(commentVo);
		PageInfo<Comment> pageInfo = new PageInfo<>(comments);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveComment(CommentVo commentVo) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentVo, comment);
		int count = commentMapper.saveComment(comment);
		return count>0?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateComment(CommentVo commentVo) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentVo, comment);
		int count = commentMapper.updateComment(comment);
		return count>0?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteCommentById(Integer id) {
		int count = commentMapper.deleteCommentById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse getCommentById(Integer id) {
		Comment comment = commentMapper.getCommentById(id);
		return comment!=null?ServerResponse.createBySuccess(comment):ServerResponse.createByError();
	}
	
	
}

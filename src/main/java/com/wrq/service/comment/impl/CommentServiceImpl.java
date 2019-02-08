package com.wrq.service.comment.impl;


import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;
import com.wrq.mapper.UserMapper;
import com.wrq.pojo.User;
import com.wrq.service.comment.ICommentService;
import com.wrq.service.user.IUserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.CommentMapper;
import com.wrq.vo.CommentVo;
import com.wrq.pojo.Comment;
import com.wrq.commons.ServerResponse;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private UserMapper userMapper;
	
	public PageInfo<CommentVo> queryCommentFirstLevel(Integer blogId, Integer pageNum, Integer pageSize){

		PageHelper.startPage(pageNum, pageSize);


		List<CommentVo> commentVoList = new ArrayList<>();

		List<Comment> comments = commentMapper.queryCommentFirstLevel(blogId);

		for (Comment comment : comments){
			CommentVo commentVo = new CommentVo();
			BeanUtils.copyProperties(comment, commentVo);

			User user = userMapper.getUserById(comment.getUserId());
			if ( user != null){
				commentVo.setHeaderPic(user.getHeaderPic());
				commentVo.setUserName(user.getUsername());
			}

			User replayUser = userMapper.getUserById(comment.getReplayUserid());
			if ( replayUser != null){
				commentVo.setReplayUserHeadPic(replayUser.getHeaderPic());
				commentVo.setReplayUserName(replayUser.getUsername());
			}

			commentVoList.add(commentVo);
		}

		PageInfo<CommentVo> pageInfo = new PageInfo<>(commentVoList);

		return pageInfo;
	}
	
}

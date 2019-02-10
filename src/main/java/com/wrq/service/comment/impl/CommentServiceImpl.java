package com.wrq.service.comment.impl;


import java.util.ArrayList;
import java.util.List;

import com.wrq.mapper.UserMapper;
import com.wrq.pojo.User;
import com.wrq.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.CommentMapper;
import com.wrq.vo.CommentVo;
import com.wrq.pojo.Comment;
import org.springframework.util.CollectionUtils;

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

			commentVoList.add(commentVo);
		}

		recursionChildren(commentVoList);

		PageInfo<CommentVo> pageInfo = new PageInfo<>(commentVoList);

		return pageInfo;
	}

	private void recursionChildren (List<CommentVo> commentVoList) {

		// 递归生成二级评论, 遍历每一个评论,看看此评论有没有下级
		for (CommentVo commentVoItem : commentVoList){

			Integer blogId = commentVoItem.getBlogId();
			Integer parentId = commentVoItem.getId();

			// 获取当前评论 id 为 parentId 的博客列表.
			List<Comment> comments = commentMapper.queryCommentByParentId(blogId, parentId);

			// 递归结束标志
			if ( !CollectionUtils.isEmpty(comments) ){

				List<CommentVo> childrenList = new ArrayList<>();

				for (Comment comment : comments){

					CommentVo commentVo = new CommentVo();
					BeanUtils.copyProperties(comment, commentVo);

					Integer commentUserId = comment.getUserId();
					User user = userMapper.getUserById(commentUserId);
					if ( user != null){
						commentVo.setHeaderPic(user.getHeaderPic());
						commentVo.setUserName(user.getUsername());
					}
					childrenList.add(commentVo);
				}

				commentVoItem.setChildren(childrenList);

				//递归
				recursionChildren(childrenList);

			}else {
				commentVoItem.setChildren(new ArrayList<>());
			}
		}
	}
}

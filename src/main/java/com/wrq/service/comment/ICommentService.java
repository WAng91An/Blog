package com.wrq.service.comment;

import com.wrq.commons.ServerResponse;
import com.wrq.vo.CommentVo;

 public interface ICommentService {
	
	 ServerResponse saveComment(CommentVo commentVo);
	
	 ServerResponse updateComment(CommentVo commentVo);
	
	 ServerResponse deleteCommentById(Integer id);
	
	 ServerResponse getCommentById(Integer id);
	
	 ServerResponse queryCommentAll(CommentVo commentVo);
}

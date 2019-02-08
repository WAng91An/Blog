package com.wrq.service.comment;

import com.github.pagehelper.PageInfo;
import com.wrq.vo.CommentVo;


public interface ICommentService {
	
	PageInfo<CommentVo> queryCommentFirstLevel(Integer blogId, Integer pageNum, Integer pageSize);
}

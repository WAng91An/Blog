package com.wrq.controller.comment;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.wrq.vo.CommentVo;
import com.wrq.service.comment.ICommentService;
import com.wrq.commons.ServerResponse;

@Controller
@Slf4j
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/comment/{id}")
	@ResponseBody
	public ServerResponse template(@PathVariable("id") Integer blogId, @RequestParam(value = "pageNum", defaultValue = "0", required = false)Integer pageNum ,
								   @RequestParam(value = "pageSize", defaultValue = "10", required = false)Integer pageSize) {

		log.info(" 请求了评论列表, 请求博客commentId = {}", blogId);

		PageInfo<CommentVo> commentVoPageInfo = commentService.queryCommentFirstLevel(blogId, pageNum, pageSize);

		return ServerResponse.createBySuccess(commentVoPageInfo);
	}

}

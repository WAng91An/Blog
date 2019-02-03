package com.wrq.controller.comment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrq.vo.CommentVo;
import com.wrq.service.comment.ICommentService;
import com.wrq.commons.ServerResponse;

/**
 * todo:评论Controller控制器类
 * CommentController
 * 作者:王瑞乾 
 * 创建时间：2019年02月03日 16:00:08  
 * @version 1.0.0 
 *
 */
@Controller
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/comment")
	public String commentindex() {
		return "comment/index";
	}

	@GetMapping("/comment/{id}")
	public String commentdetail(@PathVariable("id") Integer id,ModelMap map) {
		map.addAttribute("id", id);
		return "comment/detail";
	}
	
	
	@PostMapping("/comment/template")
	public String template(CommentVo commentVo,ModelMap map) {
		ServerResponse serverResponse = commentService.queryCommentAll(commentVo);
		map.addAttribute("pages", serverResponse.getData());
		return "comment/template";
	}
	
	
	@ResponseBody
	@GetMapping("/comment/get/{id}")
	public ServerResponse getComment(@PathVariable("id") Integer id) {
		return commentService.getCommentById(id);
	}
	
	
	@ResponseBody
	@PostMapping("/comment/save")
	public ServerResponse saveComment(@Valid CommentVo commentVo) {
		return commentService.saveComment(commentVo);
	}
	
	@ResponseBody
	@PostMapping("/comment/update")
	public ServerResponse updateComment(@Valid CommentVo commentVo) {
		return commentService.updateComment(commentVo);
	}
	
	
	@ResponseBody
	@PostMapping("/comment/delete/{id}")
	public ServerResponse deleteComment(@PathVariable("id") Integer id) {
		return commentService.deleteCommentById(id);
	}
	
}

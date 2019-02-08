package com.wrq.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {

	/* 评论id */
	@JsonProperty("commentId")
	private Integer id;

	/* 评论用户id */
	private Integer userId;

	/* 评论时间 */
	private Date createTime;

	/* 评论用户IP地址 */
	private String ip;

	/* 评论内容 */
	private String content;

	/* 博客层级 */
	private Integer parentId;

	/* 此评论回复者的id */
	private String replayUserId;

	/* 此评论回复者的名字 */
	private String replayUserName;

	/* 此评论回复者的头像 */
	private String replayUserHeadPic;

	/* 评论发布状态 */
	private String status;

	/* 评论博客的Id */
	private Integer blogId;

	/* 评论者用户名 */
	private String userName;

	/* 评论者头像 */
	private String headerPic;
}

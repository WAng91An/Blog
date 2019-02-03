package com.wrq.pojo;

import java.util.Date;

public class Comment {
	
    private Integer id;
    private Integer userId;
    private Date createTime;
    private String ip;
    private String content;
    private Integer parentId;
    private Integer replayUserid;
    private Integer status;
    private Integer blogId;
    
    public Comment() {
        super();
    }
    
    public Comment(Integer id,Integer userId,Date createTime,String ip,String content,Integer parentId,Integer replayUserid,Integer status,Integer blogId) {
        super();
        this.id = id;
        this.userId = userId;
        this.createTime = createTime;
        this.ip = ip;
        this.content = content;
        this.parentId = parentId;
        this.replayUserid = replayUserid;
        this.status = status;
        this.blogId = blogId;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getReplayUserid() {
        return replayUserid;
    }

    public void setReplayUserid(Integer replayUserid) {
        this.replayUserid = replayUserid;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
 	
 	public String toString(Integer id,Integer userId,Date createTime,String ip,String content,Integer parentId,Integer replayUserid,Integer status,Integer blogId) {
        return "Comment:【this.id:"+id+",this.userId:"+userId+",this.createTime:"+createTime+",this.ip:"+ip+",this.content:"+content+",this.parentId:"+parentId+",this.replayUserid:"+replayUserid+",this.status:"+status+",this.blogId:"+blogId+"】";
    }
    
    public static class CommentBuilder{
 	   
	    private Integer id;
	    private Integer userId;
	    private Date createTime;
	    private String ip;
	    private String content;
	    private Integer parentId;
	    private Integer replayUserid;
	    private Integer status;
	    private Integer blogId;

 	    public String toString(){
 	    	 return "Comment.CommentBuilder:【this.id:"+id+",this.userId:"+userId+",this.createTime:"+createTime+",this.ip:"+ip+",this.content:"+content+",this.parentId:"+parentId+",this.replayUserid:"+replayUserid+",this.status:"+status+",this.blogId:"+blogId+"】";
 	    }

 	    public Comment build(){
 	      return new Comment(id,userId,createTime,ip,content,parentId,replayUserid,status,blogId);
 	    }

 	    public CommentBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public CommentBuilder userId(Integer userId){
 	      this.userId = userId;
 	      return this;
 	    }
 	    
 	    public CommentBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	    public CommentBuilder ip(String ip){
 	      this.ip = ip;
 	      return this;
 	    }
 	    
 	    public CommentBuilder content(String content){
 	      this.content = content;
 	      return this;
 	    }
 	    
 	    public CommentBuilder parentId(Integer parentId){
 	      this.parentId = parentId;
 	      return this;
 	    }
 	    
 	    public CommentBuilder replayUserid(Integer replayUserid){
 	      this.replayUserid = replayUserid;
 	      return this;
 	    }
 	    
 	    public CommentBuilder status(Integer status){
 	      this.status = status;
 	      return this;
 	    }
 	    
 	    public CommentBuilder blogId(Integer blogId){
 	      this.blogId = blogId;
 	      return this;
 	    }
 	    
 	  }

 	  public static Comment.CommentBuilder builder(){
 	    return new Comment.CommentBuilder();
 	  }
}
package com.wrq.pojo;

import java.util.Date;

public class Blog {
	
    private Integer id;
    private String title;
    private Integer categoryId;
    private String description;
    private Integer userId;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private Integer isDelete;
    private String img;
    private String tags;
    private Integer isTop;
    private Integer isHot;
    private String content;
    
    public Blog() {
        super();
    }
    
    public Blog(Integer id,String title,Integer categoryId,String description,Integer userId,Date createTime,Date updateTime,Integer status,Integer isDelete,String img,String tags,Integer isTop,Integer isHot,String content) {
        super();
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
        this.description = description;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.isDelete = isDelete;
        this.img = img;
        this.tags = tags;
        this.isTop = isTop;
        this.isHot = isHot;
        this.content = content;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 	
 	public String toString(Integer id,String title,Integer categoryId,String description,Integer userId,Date createTime,Date updateTime,Integer status,Integer isDelete,String img,String tags,Integer isTop,Integer isHot,String content) {
        return "Blog:【this.id:"+id+",this.title:"+title+",this.categoryId:"+categoryId+",this.description:"+description+",this.userId:"+userId+",this.createTime:"+createTime+",this.updateTime:"+updateTime+",this.status:"+status+",this.isDelete:"+isDelete+",this.img:"+img+",this.tags:"+tags+",this.isTop:"+isTop+",this.isHot:"+isHot+",this.content:"+content+"】";
    }
    
    public static class BlogBuilder{
 	   
	    private Integer id;
	    private String title;
	    private Integer categoryId;
	    private String description;
	    private Integer userId;
	    private Date createTime;
	    private Date updateTime;
	    private Integer status;
	    private Integer isDelete;
	    private String img;
	    private String tags;
	    private Integer isTop;
	    private Integer isHot;
	    private String content;

 	    public String toString(){
 	    	 return "Blog.BlogBuilder:【this.id:"+id+",this.title:"+title+",this.categoryId:"+categoryId+",this.description:"+description+",this.userId:"+userId+",this.createTime:"+createTime+",this.updateTime:"+updateTime+",this.status:"+status+",this.isDelete:"+isDelete+",this.img:"+img+",this.tags:"+tags+",this.isTop:"+isTop+",this.isHot:"+isHot+",this.content:"+content+"】";
 	    }

 	    public Blog build(){
 	      return new Blog(id,title,categoryId,description,userId,createTime,updateTime,status,isDelete,img,tags,isTop,isHot,content);
 	    }

 	    public BlogBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public BlogBuilder title(String title){
 	      this.title = title;
 	      return this;
 	    }
 	    
 	    public BlogBuilder categoryId(Integer categoryId){
 	      this.categoryId = categoryId;
 	      return this;
 	    }
 	    
 	    public BlogBuilder description(String description){
 	      this.description = description;
 	      return this;
 	    }
 	    
 	    public BlogBuilder userId(Integer userId){
 	      this.userId = userId;
 	      return this;
 	    }
 	    
 	    public BlogBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	    public BlogBuilder updateTime(Date updateTime){
 	      this.updateTime = updateTime;
 	      return this;
 	    }
 	    
 	    public BlogBuilder status(Integer status){
 	      this.status = status;
 	      return this;
 	    }
 	    
 	    public BlogBuilder isDelete(Integer isDelete){
 	      this.isDelete = isDelete;
 	      return this;
 	    }
 	    
 	    public BlogBuilder img(String img){
 	      this.img = img;
 	      return this;
 	    }
 	    
 	    public BlogBuilder tags(String tags){
 	      this.tags = tags;
 	      return this;
 	    }
 	    
 	    public BlogBuilder isTop(Integer isTop){
 	      this.isTop = isTop;
 	      return this;
 	    }
 	    
 	    public BlogBuilder isHot(Integer isHot){
 	      this.isHot = isHot;
 	      return this;
 	    }
 	    
 	    public BlogBuilder content(String content){
 	      this.content = content;
 	      return this;
 	    }
 	    
 	  }

 	  public static Blog.BlogBuilder builder(){
 	    return new Blog.BlogBuilder();
 	  }
}
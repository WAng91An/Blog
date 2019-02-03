package com.wrq.pojo;

import java.util.Date;

public class Category {
	
    private Integer id;
    private String name;
    private Integer sort;
    private Date createTime;
    
    public Category() {
        super();
    }
    
    public Category(Integer id,String name,Integer sort,Date createTime) {
        super();
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.createTime = createTime;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
 	
 	public String toString(Integer id,String name,Integer sort,Date createTime) {
        return "Category:【this.id:"+id+",this.name:"+name+",this.sort:"+sort+",this.createTime:"+createTime+"】";
    }
    
    public static class CategoryBuilder{
 	   
	    private Integer id;
	    private String name;
	    private Integer sort;
	    private Date createTime;

 	    public String toString(){
 	    	 return "Category.CategoryBuilder:【this.id:"+id+",this.name:"+name+",this.sort:"+sort+",this.createTime:"+createTime+"】";
 	    }

 	    public Category build(){
 	      return new Category(id,name,sort,createTime);
 	    }

 	    public CategoryBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder name(String name){
 	      this.name = name;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder sort(Integer sort){
 	      this.sort = sort;
 	      return this;
 	    }
 	    
 	    public CategoryBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	  }

 	  public static Category.CategoryBuilder builder(){
 	    return new Category.CategoryBuilder();
 	  }
}
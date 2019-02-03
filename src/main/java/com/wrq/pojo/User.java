package com.wrq.pojo;

import java.util.Date;

public class User {
	
    private Integer id;
    private String username;
    private String password;
    private String headerPic;
    private Date createTime;
    
    public User() {
        super();
    }
    
    public User(Integer id,String username,String password,String headerPic,Date createTime) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.headerPic = headerPic;
        this.createTime = createTime;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
 	
 	public String toString(Integer id,String username,String password,String headerPic,Date createTime) {
        return "User:【this.id:"+id+",this.username:"+username+",this.password:"+password+",this.headerPic:"+headerPic+",this.createTime:"+createTime+"】";
    }
    
    public static class UserBuilder{
 	   
	    private Integer id;
	    private String username;
	    private String password;
	    private String headerPic;
	    private Date createTime;

 	    public String toString(){
 	    	 return "User.UserBuilder:【this.id:"+id+",this.username:"+username+",this.password:"+password+",this.headerPic:"+headerPic+",this.createTime:"+createTime+"】";
 	    }

 	    public User build(){
 	      return new User(id,username,password,headerPic,createTime);
 	    }

 	    public UserBuilder id(Integer id){
 	      this.id = id;
 	      return this;
 	    }
 	    
 	    public UserBuilder username(String username){
 	      this.username = username;
 	      return this;
 	    }
 	    
 	    public UserBuilder password(String password){
 	      this.password = password;
 	      return this;
 	    }
 	    
 	    public UserBuilder headerPic(String headerPic){
 	      this.headerPic = headerPic;
 	      return this;
 	    }
 	    
 	    public UserBuilder createTime(Date createTime){
 	      this.createTime = createTime;
 	      return this;
 	    }
 	    
 	  }

 	  public static User.UserBuilder builder(){
 	    return new User.UserBuilder();
 	  }
}
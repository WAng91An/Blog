package com.wrq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wrq.vo.UserVo;
import com.wrq.pojo.User;

/**
 * todo:用户
 * User<br/>
 * 创建人:王瑞乾<br/>
 * 时间：2019年02月03日 16:01:41 <br/>
 * @version 1.0.0<br/>
 *
 */
public interface UserMapper {
	//添加
	public int saveUser(User user);
	//修改
	public int updateUser(User user);
	//删除
	public int deleteUserById(@Param("id")Integer id);
	//查询单个
	public User getUserById(@Param("id")Integer id);
	//查询所有
	public List<User> queryUserAll(UserVo userVo);
}
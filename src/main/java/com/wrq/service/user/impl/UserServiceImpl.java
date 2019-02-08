package com.wrq.service.user.impl;


import java.util.List;

import com.wrq.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wrq.mapper.UserMapper;
import com.wrq.vo.UserVo;
import com.wrq.pojo.User;
import com.wrq.commons.ServerResponse;


/**
 * todo:用户Service实现类
 * UserServiceImpl<br/>
 * 作者:王瑞乾<br/>
 * 创建时间：2019年02月03日 16:01:41 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	public ServerResponse queryUserAll(UserVo userVo){
		PageHelper.startPage(userVo.getPageNo(), userVo.getPageSize());
		List<User> users = userMapper.queryUserAll(userVo);
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	@Override
	public ServerResponse saveUser(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		int count = userMapper.saveUser(user);
		return count>0?ServerResponse.createBySuccess(user):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse updateUser(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		int count = userMapper.updateUser(user);
		return count>0?ServerResponse.createBySuccess(user):ServerResponse.createByError();
	}

	
	@Override
	public ServerResponse deleteUserById(Integer id) {
		int count = userMapper.deleteUserById(id);
		return count>0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

	
	@Override
	public User getUserById(Integer id) {
		User user = userMapper.getUserById(id);
		return user;
	}
	
	
}

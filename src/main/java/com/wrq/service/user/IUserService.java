package com.wrq.service.user;

import com.wrq.commons.ServerResponse;
import com.wrq.pojo.User;
import com.wrq.vo.UserVo;

public interface IUserService {
	
	ServerResponse saveUser(UserVo userVo);

	ServerResponse updateUser(UserVo userVo);
	
	ServerResponse deleteUserById(Integer id);
	
	User getUserById(Integer id);
	
	ServerResponse queryUserAll(UserVo userVo);
}

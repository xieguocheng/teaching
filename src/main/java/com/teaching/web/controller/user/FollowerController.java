package com.teaching.web.controller.user;

import com.teaching.mapper.UserFollowMapper;
import com.teaching.pojo.AuthUser;
import com.teaching.pojo.UserFollow;
import com.teaching.service.UserFollowsService;
import com.teaching.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 用户关注
 */
@Controller
public class FollowerController {
	
	@Autowired
	private UserFollowsService userFollowsService;
	@Autowired
	private UserFollowMapper userFollowMapper;
	
	@PostMapping(value = "user/follow/doFollow")
	@ResponseBody
	public ApiResponse doFollow(Integer followId){

		//获取当前登录的用户
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AuthUser authUser= (AuthUser) auth.getPrincipal();

		UserFollow userFollow=new UserFollow();
		userFollow.setUserId(authUser.getId());
		userFollow.setFollowId(followId);
		userFollowMapper.insertSelective(userFollow);
		return ApiResponse.ofMessage(0,null);


	}
	
	/**
	 * 取消关注
	 */
	@PostMapping(value = "user/follow/isFollow")
	@ResponseBody
	public ApiResponse isFollow(Integer followId){

		//获取当前登录的用户
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AuthUser authUser= (AuthUser) auth.getPrincipal();

		UserFollow userFollow=new UserFollow();
		userFollow.setUserId(authUser.getId());
		userFollow.setFollowId(followId);
		userFollowMapper.delete(userFollow);
		return ApiResponse.ofMessage(1,null);

	}
	
}



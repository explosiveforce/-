package com.ndgwww.HR.management.Controller;

import com.ndgwww.HR.management.Config.MD5UtilConfig;
import com.ndgwww.HR.management.Service.ManagementService;

import com.ndgwww.HR.management.pojo.Management;
import com.ndgwww.HR.management.util.JWTUtil;
import com.ndgwww.HR.management.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * RestController:返回的数据都是json格式
 */
@RestController
@RequestMapping("/user")
//这个是登录的 /user/login  {"username":"","password":""}
public class LoginController {
	@Autowired
	private ManagementService managementService;
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ResponseData login(@RequestBody Management user, HttpServletRequest request){//请求中传递json格式的对象，转为java中的对象
		user.setPassword(MD5UtilConfig.string2MD5(user.getPassword()));
		Management loginUser = managementService.login(user);
		ResponseData responseData = ResponseData.ok();
		if(loginUser!=null) {
			//生成token
			String token = JWTUtil.generToken("1", "Jersey-Security-Basic", loginUser.getEmail().toString());
			//向浏览器返回token，客户端受到此token后存入cookie中，或者h5的本地存储中
			responseData.putDataValue("token", token);
			//以及用户
			responseData.putDataValue("user", loginUser);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",loginUser);
//			session.setAttribute("cart",cartService.getCartListByUserId(loginUser.getId()));
		}else {
			//用户或者密码错误
			responseData=ResponseData.login();
		}
		return responseData;
	}
}

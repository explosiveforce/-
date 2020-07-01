package com.ndgwww.HR.management.Controller;
import com.ndgwww.HR.management.Config.MD5UtilConfig;
import com.ndgwww.HR.management.Config.RespBean;
import com.ndgwww.HR.management.Service.DepartmentService;
import com.ndgwww.HR.management.Service.UserService;
import com.ndgwww.HR.management.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Enumeration;
import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.ch.DatagramSocketAdaptor;
@RestController


@RequestMapping("/hello")
//注册员工
public class Registered {
    @Autowired
    UserService userService;
    @Autowired
    JavaMailSenderImpl mailSender;
    Random r = new Random();
    public String index = "1234";

    @RequestMapping(value = "/yz", method = RequestMethod.GET)
    public RespBean hellow(@RequestParam("email") String email) {      //发验证码的接口
        //邮箱是否被注册
        User user1 = userService.Email(email);
        if (user1 == null) {
            String yzm1 = "" + (1000 + r.nextInt(8999));//随机数生成一个4位随机数字验证码
            index = yzm1;
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject("西瓜人事验证码");
            mailMessage.setText("欢迎注册西瓜人事管理系统，您的注册码为：" + yzm1);
            mailMessage.setTo(email);
            mailMessage.setFrom("1753400030@qq.com");
            mailSender.send(mailMessage);
            return new RespBean("success", "邮箱发送成功");
        } else {
            return new RespBean("error", "邮箱已经被注册");
        }
    }

    //    @RequestMapping(value = "/dl",method = RequestMethod.POST)
//    public String hellow1(@RequestParam("username") String username,@RequestParam("password") String password) {      //登录的接口
//        User user2 =userService.Login(username);
//
//        if(user2==null){
//            return "-1";//账号不存在
//        }else if(user2.getPassword().equals(password)) {
//            return user2.getUsername();//登录成功
//        }
//        else {
//            return "0";//密码错误
//        }
//    }
    @RequestMapping(value = "/zc", method = RequestMethod.POST)
    public RespBean hellow2(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("yzm") String yzm) {      //注册的接口
        //先康康验证码

        if (index.equals(yzm)) {

            User user3 = userService.Login(username);

            if (user3 == null) {

                password = MD5UtilConfig.string2MD5(password);
                int i = userService.Zhuce(username, password, email);
                if (i > 0) {
                    return new RespBean("success", "注册成功");
                }else {
                    return new RespBean("error", "注册失败仔细检查");
                }
            } else {
                return new RespBean("error", "用户名已经存在");
            }

        } else {
            return new RespBean("error", "验证码错误");
        }
    }
}




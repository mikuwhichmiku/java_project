package com.sxt.controller;

import com.sxt.pojo.PClass;
import com.sxt.pojo.Users;
import com.sxt.service.PClassService;
import com.sxt.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * exams   com.sxt.controller
 * 2022-06-26  09:56
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/26  9:56
 */
@Controller
public class StuUserController {
    @Autowired
    UsersService usersService;
    @Autowired
    PClassService pClassService;

    @GetMapping("/register")
    public String toRegister(Model model){
        List<PClass> allPClass = pClassService.getAllPClass();
        model.addAttribute("list",allPClass);
        return "student/register";
    }

    @PostMapping("/CanRegister")
    public String register(Users users,String username,String  userpwd,String truename,Integer classid,String email, String phone,HttpServletRequest request){
        Users byName = usersService.getByName(username);
        users.setUsername(username);
        users.setUserpwd(userpwd);
        users.setTruename(truename);
        users.setClassid(classid);
        users.setUsermail(email);
        users.setUsertel(phone);
        usersService.addUsers(users);
        if (byName==null){
            if (userpwd.equals("")){
                request.getSession().setAttribute("msg1","密码为空");
                return "redirect:/register";
            }
            if (truename.equals("")){
                request.getSession().setAttribute("msg2","真实姓名为空");
                return "redirect:/register";
            }
            if (username.equals("")){
                request.getSession().setAttribute("msg3","用户名为空");
                return "redirect:/register";
            }
            System.out.println("用户可以注册");
            return "redirect:/toStuLogin";
        }else {
            System.out.println("用户已存在");
            return "redirect:/register";
        }

    }
    //修改密码
    @PostMapping("/xiugai")
    public String updateUserPwd(String userpwd,Integer userid,String email, String phone){
        // 更新密码
        Integer updatePwdResult = 1; // 默认设置为成功状态
        if (userpwd != null && !userpwd.isEmpty()) {
            updatePwdResult = usersService.updUserPwd(userpwd, userid);
        }

        // 更新邮箱和电话
        Integer updateEmailResult = 1; // 默认设置为成功状态
        Integer updatePhoneResult = 1; // 默认设置为成功状态

        if (email != null && !email.isEmpty()) {
            updateEmailResult = usersService.updUserEmail(email, userid);
        }

        if (phone != null && !phone.isEmpty()) {
            updatePhoneResult = usersService.updUserPhone(phone, userid);
        }

        // 检查所有更新操作的结果
        if (updatePwdResult == 0 || updateEmailResult == 0 || updatePhoneResult == 0){
            // 处理失败情况，比如返回错误信息或重新显示表单
            return "";
        } else {
            return "redirect:/toStuLogin";  // 成功后重定向到登录页面
        }

    }
    //退出登陆
    @GetMapping("/logout")
    public String slogout(HttpServletRequest request){
        request.getSession().removeAttribute("lis");
        request.getSession().removeAttribute("truename");
        return "redirect:/toStuLogin";
    }
}

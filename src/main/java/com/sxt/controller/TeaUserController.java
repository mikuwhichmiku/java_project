package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * exams   com.sxt.controller
 * 2022-07-24  14:16
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/24  14:16
 */
@Controller
public class TeaUserController {
    //退出登陆
    @GetMapping("/Tlogout")
    public String Tlogout(HttpServletRequest request){
        request.getSession().removeAttribute("Teauserid");
        request.getSession().removeAttribute("TeaClassid");
        request.getSession().removeAttribute("Teatruename");

        return "redirect:/toTeacher";
    }
}

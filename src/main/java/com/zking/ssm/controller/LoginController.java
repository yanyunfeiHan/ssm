package com.zking.ssm.controller;

import com.zking.ssm.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(SysUser sysUser,Model model){
        return null;
    }
}

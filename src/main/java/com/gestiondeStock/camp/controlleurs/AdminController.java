package com.gestiondeStock.camp.controlleurs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/")
    public String dashboard(){
        return "/back/adminDashboard";
    }

}

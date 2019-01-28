package com.wrq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by wangqian on 2019/1/27.
 */
@Controller
public class IndexController {


    @GetMapping("/index")
    public String index () {
        return "index";
    }

    @PostMapping("/index2")
    public String index2 () {
        return "index2";
    }
}

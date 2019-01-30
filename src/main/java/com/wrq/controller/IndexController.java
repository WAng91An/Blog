package com.wrq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;

/**
 * Created by wangqian on 2019/1/27.
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping("/index")
    public String index () {
        log.info(" 请求 /index ");
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String detail  (@PathVariable Integer id) {
        log.info(" 请求 /detail ");
        return  "detail";
    }
}

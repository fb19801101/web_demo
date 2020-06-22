package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-04-01 15:13
 */
@Controller
@RequestMapping("left")
public class LeftController {
    @RequestMapping("toLeft")
    public String toLeft() {
        return "left";
    }
}
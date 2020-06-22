package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-04-01 15:13
 */
@Controller
@RequestMapping("right")
public class RightController {
    @RequestMapping("toBar")
    public ModelAndView toBar(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/")+"res/img/right";
        List<File> listFile = getFileList(path);
        HashMap mapMsg = new HashMap();
        List<String> list = new ArrayList<>();
        for(File file : listFile) {
            list.add(file.getName());
        }

        mapMsg.put("list", list);
        mapMsg.put("size", list.size());
        return new ModelAndView("bar", "message", mapMsg);
    }

    @RequestMapping("toRight")
    public ModelAndView toRight(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletContext().getRealPath("/")+"res/img/right";
        List<File> listFile = getFileList(path);
        HashMap mapMsg = new HashMap();
        List<String> list = new ArrayList<>();
        for(File file : listFile) {
            list.add(file.getName());
        }

        mapMsg.put("list", list);
        mapMsg.put("size", list.size());
        return new ModelAndView("right", "message", mapMsg);
    }

    public List<File> getFileList(String strPath) {
        List<File> filelist = new ArrayList<>();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath()); //遍历子文件夹里面的东西
                } else if (fileName.endsWith("exe")) { // 以***结尾的文件
                    String strFileName = files[i].getAbsolutePath();
                    filelist.add(files[i]);
                } else {
                    filelist.add(files[i]);
                    continue;
                }
            }
        }
        return filelist;
    }
}

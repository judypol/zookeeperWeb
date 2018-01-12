package com.guanyi.zkweb.controller;

import com.alibaba.fastjson.JSON;
import com.guanyi.zkweb.utils.ZkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    ZkUtils zkUtils;

    @RequestMapping("/home")
    public ModelAndView index(String zkPath){
        ModelAndView view=new ModelAndView("/home");
        return view;
    }

    /**
     * 获取zk节点数据
     * @param zkPath
     * @return
     */
    @RequestMapping("/getChilds")
    public @ResponseBody String getChilds(String zkPath) throws Exception{
        List<String> childNodes=zkUtils.getChildNodes(zkPath);
        return JSON.toJSONString(childNodes);
    }
}

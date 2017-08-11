package com.minminxu;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {

    @Value("${config.path}")
    private String configPath;

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ModelAndView page(@PathVariable(required = false) String code) throws Exception {

        if (StringUtils.isEmpty(code)) {
            code = "index";
        }

        // 读取site.config
        Map siteConfig = readJsonFile(configPath + "/site.json");
        siteConfig.put("isFacebookLink", StringUtils.isNotEmpty(siteConfig.get("facebookLink").toString()));
        siteConfig.put("isTwitterLink", StringUtils.isNotEmpty(siteConfig.get("twitterLink").toString()));
        siteConfig.put("isInstagramLink", StringUtils.isNotEmpty(siteConfig.get("instagramLink").toString()));
        siteConfig.put("isLinkedinLink", StringUtils.isNotEmpty(siteConfig.get("linkedinLink").toString()));
        siteConfig.put("isEnvelopeLink", StringUtils.isNotEmpty(siteConfig.get("envelopeLink").toString()));
        siteConfig.put("isSoundcloudLink", StringUtils.isNotEmpty(siteConfig.get("soundcloudLink").toString()));
        siteConfig.put("isTumblrLink", StringUtils.isNotEmpty(siteConfig.get("tumblrLink").toString()));

        // 读取menu.config
        Map menuConfig = readJsonFile(configPath + "/menu.json");
        for (Object key : menuConfig.keySet()) {
            Map value = (Map) menuConfig.get(key);
            boolean active = false;
            if (value.containsKey("path")) {
                if (value.get("path").toString().toLowerCase().equals("/" + code.toLowerCase())) {
                    active = true;
                }
            } else {
                Map childs = (Map) value.get("childs");
                for (Object childKey : childs.keySet()) {
                    Map childValue = (Map) childs.get(childKey);
                    if (childValue.get("path").toString().toLowerCase().equals("/" + code.toLowerCase())) {
                        active = true;
                        break;
                    }
                }
            }
            value.put("path", value.containsKey("path") ? (value.get("path").equals("/index") ? "/" : value.get("path")) : "javascript:;");
            value.put("isChild", value.containsKey("childs"));
            value.put("active", active);
        }

        // 读取页面信息
        Object viewData = null;
        if (!"about".equals(code)) {
            List<Map> pageDatas = readListJsonFile(configPath + "/page/" + code + ".json");
            long indexNum = 0;
            for (Map data : pageDatas) {
                indexNum++;
                data.put("number", indexNum);
                data.put("hidden", indexNum > 1);
            }
            viewData = pageDatas;
        } else {
            List<Map> pageDatas = readListJsonFile(configPath + "/page/" + code + ".json");
            for (Map data : pageDatas) {
                if (!data.containsKey("titles")) {
                    data.put("titles", new ArrayList());
                }
                if (!data.containsKey("descs")) {
                    data.put("descs", new ArrayList());
                }
                data.put("isImage", data.containsKey("image"));
            }
            viewData = pageDatas;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("site", siteConfig);
        mv.addObject("menu", menuConfig);
        mv.addObject("data", viewData);
        mv.addObject("code", code);
        mv.setViewName("about".equals(code) ? "about" : "index");
        return mv;
    }

    private Map readJsonFile(String filePath) throws Exception {
        return JSON.parseObject(new FileInputStream(filePath), Charset.forName("utf-8"), LinkedHashMap.class);
    }

    private List<Map> readListJsonFile(String filePath) throws Exception {
        return JSON.parseObject(new FileInputStream(filePath), Charset.forName("utf-8"), List.class);
    }
}
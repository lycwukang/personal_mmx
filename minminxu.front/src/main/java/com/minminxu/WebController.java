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
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {

    @Value("${config.path}")
    private String configPath;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@PathVariable(required = false) String code) throws Exception {
        return page("index");
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ModelAndView page(@PathVariable(required = false) String code) throws Exception {

        if (StringUtils.isEmpty(code)) {
            code = "index";
        }

        // 读取site.config
        Map siteConfig = readJsonFile(configPath + "/site.json", Map.class);
        siteConfig.put("isFacebookLink", StringUtils.isNotEmpty(siteConfig.get("facebookLink").toString()));
        siteConfig.put("isTwitterLink", StringUtils.isNotEmpty(siteConfig.get("twitterLink").toString()));
        siteConfig.put("isInstagramLink", StringUtils.isNotEmpty(siteConfig.get("instagramLink").toString()));
        siteConfig.put("isLinkedinLink", StringUtils.isNotEmpty(siteConfig.get("linkedinLink").toString()));
        siteConfig.put("isEnvelopeLink", StringUtils.isNotEmpty(siteConfig.get("envelopeLink").toString()));
        siteConfig.put("isSoundcloudLink", StringUtils.isNotEmpty(siteConfig.get("soundcloudLink").toString()));
        siteConfig.put("isTumblrLink", StringUtils.isNotEmpty(siteConfig.get("tumblrLink").toString()));
        siteConfig.put("isBehanceLink", StringUtils.isNotEmpty(siteConfig.get("behanceLink").toString()));

        // 读取menu.config
        MenuViewModel menuViewModel = new MenuViewModel();
        MenuModel menuConfig = readJsonFile(configPath + "/menu.json", MenuModel.class);
        for (MenuElementModel menu : menuConfig) {
            MenuElementViewModel viewModel = new MenuElementViewModel();
            MenuViewModel menuChildViewModel = new MenuViewModel();
            boolean active = false;
            if (menu.getChilds() == null || menu.getChilds().size() == 0) {
                if (StringUtils.isNotEmpty(menu.getPath()) && menu.getPath().toLowerCase().equals("/" + code.toLowerCase())) {
                    active = true;
                }
            } else {
                for (MenuElementModel childMenu : menu.getChilds()) {
                    MenuElementViewModel viewChildModel = new MenuElementViewModel();
                    if (childMenu.getPath().toLowerCase().equals("/" + code.toLowerCase())) {
                        active = true;
                    }
                    viewChildModel.setName(childMenu.getName());
                    viewChildModel.setChildAble(false);
                    viewChildModel.setActive(false);
                    viewChildModel.setPath(childMenu.getPath());
                    menuChildViewModel.add(viewChildModel);
                }
            }
            viewModel.setName(menu.getName());
            viewModel.setChilds(menuChildViewModel);
            viewModel.setActive(active);
            viewModel.setChildAble(menuChildViewModel.size() > 0);
            viewModel.setPath(!viewModel.isChildAble() ? ("/index".equals(menu.getPath()) ? "/" : menu.getPath()) : "javascript:;");
            menuViewModel.add(viewModel);
        }

        // 读取页面信息
        Object viewData = null;
        if (!"about".equals(code)) {
            PageViewModel pageViewModel = new PageViewModel();
            PageModel pageDatas = readJsonFile(configPath + "/page/" + code + ".json", PageModel.class);
            int indexNum = 0;
            for (PageElementModel data : pageDatas) {
                PageElementViewModel viewModel = new PageElementViewModel();
                viewModel.setImage(data.getImage());
                viewModel.setTitle(data.getTitle());
                viewModel.setDesc(data.getDesc());
                viewModel.setNumber(++indexNum);
                viewModel.setHidden(indexNum > 1);
                pageViewModel.add(viewModel);
            }
            viewData = pageViewModel;
        } else {
            AboutViewModel pageViewModel = new AboutViewModel();
            AboutModel pageDatas = readJsonFile(configPath + "/page/" + code + ".json", AboutModel.class);
            for (AboutElementModel data : pageDatas) {
                AboutElementViewModel viewModel = new AboutElementViewModel();
                viewModel.setImage(data.getImage());
                viewModel.setImageAble(StringUtils.isNotEmpty(data.getImage()));
                viewModel.setTitles(data.getTitles());
                viewModel.setDescs(data.getDescs());
                pageViewModel.add(viewModel);
            }
            viewData = pageViewModel;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("site", siteConfig);
        mv.addObject("menu", menuViewModel);
        mv.addObject("data", viewData);
        mv.addObject("code", code);
        mv.setViewName("about".equals(code) ? "about" : "index");
        return mv;
    }

    private <T> T readJsonFile(String filePath, Type type) throws Exception {
        return JSON.parseObject(new FileInputStream(filePath), Charset.forName("utf-8"), type);
    }
}
package com.minminxu;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebController {

    @Value("${config.path}")
    private String configPath;

    @RequestMapping(value = "/config/site", method = RequestMethod.GET)
    public Map siteConfig() throws Exception {

        return readJsonFile(configPath + "/site.json", Map.class);
    }

    @RequestMapping(value = "/config/site", method = RequestMethod.POST)
    public Map saveSiteConfig(@RequestBody Map config) throws Exception {

        Map result = new HashMap();
        try {
            saveJsonFile(configPath + "/site.json", config);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
        }
        return result;
    }

    @RequestMapping(value = "/config/menu", method = RequestMethod.GET)
    public MenuModel menuConfig() throws Exception {

        try {
            return readJsonFile(configPath + "/menu.json", MenuModel.class);
        } catch (Exception e) {
            return new MenuModel();
        }
    }

    @RequestMapping(value = "/config/menu", method = RequestMethod.POST)
    public Map saveMenuConfig(@RequestBody MenuModel config) throws Exception {

        Map result = new HashMap();
        try {
            saveJsonFile(configPath + "/menu.json", config);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
        }
        return result;
    }

    @RequestMapping(value = "/config/page/{code}", method = RequestMethod.GET)
    public PageModel pageConfig(@PathVariable String code) throws Exception {

        try {
            return readJsonFile(configPath + "/page/" + code + ".json", PageModel.class);
        } catch (Exception e) {
            return new PageModel();
        }
    }

    @RequestMapping(value = "/config/page/{code}", method = RequestMethod.POST)
    public Map savePageConfig(@PathVariable String code, @RequestBody PageModel config) throws Exception {

        Map result = new HashMap();
        try {
            saveJsonFile(configPath + "/page/" + code + ".json", config);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
        }
        return result;
    }

    @RequestMapping(value = "/config/page/special/about", method = RequestMethod.GET)
    public AboutModel aboutConfig() throws Exception {

        try {
            return readJsonFile(configPath + "/page/about.json", AboutModel.class);
        } catch (Exception e) {
            return new AboutModel();
        }
    }

    @RequestMapping(value = "/config/page/special/about", method = RequestMethod.POST)
    public Map saveAboutConfig(@RequestBody AboutModel config) throws Exception {

        Map result = new HashMap();
        try {
            saveJsonFile(configPath + "/page/about.json", config);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
        }
        return result;
    }

    private <T> T readJsonFile(String filePath, Type type) throws Exception {
        return JSON.parseObject(new FileInputStream(filePath), Charset.forName("utf-8"), type);
    }

    private void saveJsonFile(String filePath, Object data) throws Exception {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(JSON.toJSONString(data));
        fileWriter.close();
    }
}
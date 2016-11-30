package com.recklessmo.web.biz;

import com.alibaba.fastjson.JSONObject;
import com.recklessmo.model.Page.Frame;
import com.recklessmo.response.JsonResponse;
import com.recklessmo.service.biz.FrameService;
import com.recklessmo.service.ftp.FtpUploadService;
import com.recklessmo.service.template.TemplateService;
import com.recklessmo.web.webmodel.page.AboutPage;
import com.recklessmo.web.webmodel.page.CoverPage;
import com.recklessmo.web.webmodel.page.MovieListPage;
import org.apache.velocity.VelocityContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 在这里管理首页的东西, 包括选择图片(图片列表), 设定跳转(页面列表)
 *
 * Created by hpf on 11/11/16.
 */
@Controller
@RequestMapping("/v1/cover/publish")
public class CoverController {

    @Resource
    private TemplateService templateService;
    @Resource
    private FtpUploadService ftpUploadService;
    @Resource
    private FrameService frameService;

    @PreAuthorize("hasAnyAuthority('login')")
    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResponse publishIndex(@RequestBody CoverPage page){
        VelocityContext context = new VelocityContext();
        try {
            context.put("data", page);
            Frame frame = frameService.getById(1);
            frame.setContent(JSONObject.toJSONString(page));
            frameService.updateContent(frame);
            String content = templateService.getTemplate(context, "/templates/index.vm");
            ftpUploadService.uploadFileByFtp("/www", content, "index.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResponse(200, null, null);
    }

    @PreAuthorize("hasAnyAuthority('login')")
    @RequestMapping(value = "/about", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResponse publishAbout(@RequestBody AboutPage page){
        VelocityContext context = new VelocityContext();
        try {
            context.put("data", page);
            Frame frame = frameService.getById(2);
            frame.setContent(JSONObject.toJSONString(page));
            frameService.updateContent(frame);
            String content = templateService.getTemplate(context, "/templates/about.vm");
            ftpUploadService.uploadFileByFtp("/www", content, "about.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResponse(200, null, null);
    }

    @PreAuthorize("hasAnyAuthority('login')")
    @RequestMapping(value = "/movieList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResponse publishMovieList(@RequestBody MovieListPage page){
        VelocityContext context = new VelocityContext();
        try {
            context.put("data", page);
            Frame frame = frameService.getById(3);
            frame.setContent(JSONObject.toJSONString(page));
            frameService.updateContent(frame);
            String content = templateService.getTemplate(context, "/templates/movie-list.vm");
            ftpUploadService.uploadFileByFtp("/www", content, "movie-list.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResponse(200, null, null);
    }

}

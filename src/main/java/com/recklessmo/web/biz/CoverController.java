package com.recklessmo.web.biz;

import com.recklessmo.response.JsonResponse;
import com.recklessmo.service.ftp.FtpUploadService;
import com.recklessmo.service.template.TemplateService;
import com.recklessmo.web.webmodel.page.CoverPage;
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
@RequestMapping("/v1/cover")
public class CoverController {

    @Resource
    private TemplateService templateService;
    @Resource
    private FtpUploadService ftpUploadService;

    //设定图片地址, 跳转链接
    @PreAuthorize("hasAnyAuthority('login')")
    @RequestMapping(value = "/publish", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResponse publish(@RequestBody CoverPage page){
        CoverPage coverPage = new CoverPage();
        VelocityContext context = new VelocityContext();
        try {
            coverPage.setImg1("http://www.jqpictures.com/uploads/image/20160905/1473073853.jpg");
            coverPage.setImg2("http://www.jqpictures.com/uploads/image/20160905/1473073853.jpg");
            coverPage.setImg3("http://www.jqpictures.com/uploads/image/20160905/1473073853.jpg");
            context.put("data", coverPage);
            String content = templateService.getTemplate(context, "/templates/index.vm");
            ftpUploadService.uploadFileByFtp("/www", content, "index.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResponse(200, null, null);
    }

}

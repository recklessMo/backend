package com.recklessmo.web.biz;

import com.qiniu.util.Json;
import com.recklessmo.response.JsonResponse;
import com.recklessmo.service.ftp.FtpUploadService;
import com.recklessmo.service.template.TemplateService;
import com.recklessmo.web.webmodel.page.CoverPage;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * 在这里管理首页的东西, 包括选择图片, 设定跳转
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
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse publish(@RequestBody CoverPage coverPage){
        VelocityContext context = new VelocityContext();
        try {
            context.put("data", coverPage);
            String content = templateService.getTemplate(context, "index.vm");
            ftpUploadService.uploadFileByFtp("/www", content, "index.html");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResponse(200, null, null);
    }

}

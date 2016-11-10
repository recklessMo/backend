package com.recklessmo.web.file;

import com.recklessmo.response.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * 用于文件上传
 * Created by hpf on 9/9/16.
 */
@Controller
@RequestMapping("common/file")
public class FileUploadController {


    @RequestMapping(value = "/score/uploadExcel", method = {RequestMethod.POST})
    @ResponseBody
    public JsonResponse scoreFileUpload(@RequestParam("file")MultipartFile multipartFile) throws Exception{

        return new JsonResponse(200, null, null);
    }



}

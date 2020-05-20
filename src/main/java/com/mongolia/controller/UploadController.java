package com.mongolia.controller;

import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.util.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.InputStream;

/**
 * 文件上传api接口
 * @author Dong.w
 */
@RestController
@RequestMapping(value = "/api/upload", method = RequestMethod.POST)
public class UploadController {

    @PostMapping("/image")
    public BaseResultVO uploadImg(@NotNull @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        try {
            String realPath = request.getServletContext().getRealPath("/upload/image");
            String save = UploadUtils.save(realPath, multipartFile);
            return new SuccessResultVO(save);
        }catch (Exception e){
            e.printStackTrace();
            return new FailedResultVO("上传失败");
        }
    }

    @PostMapping("/audio")
    public BaseResultVO uploadAudio(@NotNull @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        try {
            String realPath = request.getServletContext().getRealPath("/upload/audio");
            String save = UploadUtils.save(realPath, multipartFile);
            return new SuccessResultVO(save);
        }catch (Exception e){
            e.printStackTrace();
            return new FailedResultVO("上传失败");
        }
    }

    @PostMapping("/lrc")
    public BaseResultVO uploadLrc(@NotNull @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        try {
            String realPath = request.getServletContext().getRealPath("/upload/lrc");
            String save = UploadUtils.save(realPath, multipartFile);
            return new SuccessResultVO(save);
        }catch (Exception e){
            e.printStackTrace();
            return new FailedResultVO("上传失败");
        }
    }

}

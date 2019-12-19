package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@RestController
public class UpLoadController {
    @PostMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile file) throws Exception {
        String uploadDir = "D:/chushen/upload/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            dir.mkdirs();
        }
        System.out.println("-- > " + file);
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID() + suffix;
        File serverFile = new File(uploadDir + filename);
        file.transferTo(serverFile);
        return "upload/" + filename;
    }

    @GetMapping("/upload/{name}.{suffix}")
    public void upload(@PathVariable("name") String name,
                       @PathVariable("suffix") String suffix,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {
        String imagePath = "D:\\chushen\\upload\\" + name + "." + suffix;
        response.reset();
        OutputStream output = response.getOutputStream();// 得到输出流

        response.setContentType("image/gif;charset=GB2312");// 设定输出的类型
        // 得到图片的真实路径

        BufferedImage bi = ImageIO.read(new File(imagePath));
        ImageIO.write(bi, "png", output);
        // 得到图片的文件流
        InputStream imageIn = new FileInputStream(new File(imagePath));

        output.close();
    }
}

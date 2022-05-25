package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.UriUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ViewController {

    @Value("${test.file}")
    ///Users/jelly/Desktop/images/test/
    private String fileDir;

    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    //private final FileStore fileStore;

    @PostMapping("/upload")
    public String saveFile(@RequestParam String itemName,
                           @RequestParam MultipartFile file, HttpServletRequest
                                   request) throws IOException {
        log.info("request={}", request);
        log.info("itemName={}", itemName);
        log.info("multipartFile={}", file);
        System.out.println("fileDir = " + fileDir);
        if (!file.isEmpty()) {
            String fullPath = fileDir + file.getOriginalFilename();
            log.info("파일 저장 fullPath={}", fullPath);
            file.transferTo(new File(fullPath));
        }
        return "upload-form";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public ResponseEntity<UrlResource> downloadImage(@PathVariable String filename) throws
            MalformedURLException {
        System.out.println("filename = " + filename);
        UrlResource resource = new UrlResource("file:/Users/jelly/Desktop/images/test/2.png");

        String encodedUploadFileName = UriUtils.encode("2.png", StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\""+encodedUploadFileName+"\"";

        return ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION, contentDisposition
        ).body(resource);
    }

}




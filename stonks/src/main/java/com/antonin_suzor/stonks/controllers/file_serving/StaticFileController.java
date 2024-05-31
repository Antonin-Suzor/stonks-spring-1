package com.antonin_suzor.stonks.controllers.file_serving;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaticFileController {

    private final ResourceLoader resourceLoader;

    public StaticFileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<Resource> test() {
        Resource resource = resourceLoader.getResource("classpath:static/text.txt");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);
    }
}

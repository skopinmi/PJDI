package ru.geekbrains.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/hello")
    public String indexPage () {
        return "index";
    }

    @GetMapping("/get")
    public String getPage () {
        logger.info("get");
        return "get";
    }

    @PostMapping("/post")
    public String postPage () {
        logger.info("post");
        return "post";
    }
}

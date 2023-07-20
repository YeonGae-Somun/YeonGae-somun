package com.jpa.yeongaesomun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-experience/*")
public class ProductExperienceController {

    @GetMapping("list")
    public void goToList(){

    }

    @GetMapping("detail")
    public void goToDetail(){

    }

    @GetMapping("newItem")
    public void goToNewItem(){

    }

    @GetMapping("store")
    public void goToStore(){

    }
}

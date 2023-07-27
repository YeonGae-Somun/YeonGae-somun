package com.jpa.yeongaesomun.controller.productExperience;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/product-experiences/*")
public class ProductExperienceRestController {
    @GetMapping("list")
    public void goToList(){

    }

    @GetMapping("detail")
    public void goToDetail(){

    }

    @GetMapping("newItem")
    public void goToNewItem(){

    }

    @GetMapping("reviewList")
    public void goToReivewList(){

    }

    @GetMapping("reviewDetail")
    public void goToReviewDetail(){

    }
}

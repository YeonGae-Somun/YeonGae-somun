package com.jpa.yeongaesomun.controller.productExperience;

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

    @GetMapping("reviewList")
    public void goToReivewList(){

    }

    @GetMapping("reviewDetail")
    public void goToReviewDetail(){

    }
}

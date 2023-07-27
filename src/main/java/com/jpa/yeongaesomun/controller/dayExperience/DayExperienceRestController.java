package com.jpa.yeongaesomun.controller.dayExperience;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/day-experiences/*")
public class DayExperienceRestController {

    @GetMapping("list")
    public void goToList(){

    }

    @GetMapping("detail")
    public void goToDetail(){

    }

    @GetMapping("review")
    public void goToReview(){

    }

    @GetMapping("reviewDetail")
    public void goToReviewDetail(){

    }
}

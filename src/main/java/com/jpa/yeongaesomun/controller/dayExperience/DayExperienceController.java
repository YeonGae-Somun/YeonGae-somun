package com.jpa.yeongaesomun.controller.dayExperience;


import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import com.jpa.yeongaesomun.service.dayexperience.DayExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/day-experience/*")
public class DayExperienceController {
    private final DayExperienceService dayExperienceService;

    @GetMapping("list")
    public void goToList(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model){
        final Page<DayExperience> pagination = dayExperienceService.getList(pageable);
        model.addAttribute("pagination", pagination);
    }

    @GetMapping("/api/list")
    @ResponseBody
    public Slice<DayExperience> getList(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return null;
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

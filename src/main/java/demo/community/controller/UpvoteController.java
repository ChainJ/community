package demo.community.controller;

import demo.community.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : JiangCheng
 * @date : 2021/8/28 2:33 下午
 */
//@RestController
@RequestMapping("/upvote")
public class UpvoteController {
    @Autowired
    UpvoteService upvoteService;

    @GetMapping("/random")
    public boolean randomUpvote() {
        return upvoteService.randomUpvote();
    }

    @GetMapping("/random/count")
    public long randomCount() {
        return upvoteService.randomCount();
    }

    @GetMapping("/random/voted")
    public boolean randomVoted() {
        return upvoteService.randomVoted();
    }

}

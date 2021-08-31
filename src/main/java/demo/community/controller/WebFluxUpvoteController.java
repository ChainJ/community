package demo.community.controller;

import demo.community.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author : JiangCheng
 * @date : 2021/8/28 2:33 下午
 */
@RestController
@RequestMapping("/upvote")
public class WebFluxUpvoteController {
    @Autowired
    UpvoteService upvoteService;

    @GetMapping("/random")
    public Mono<Boolean> randomUpvote() {
        return Mono.just(upvoteService.randomUpvote());
    }

    @GetMapping("/random/count")
    public Mono<Long> randomCount() {
        return Mono.just(upvoteService.randomCount());
    }

    @GetMapping("/random/voted")
    public Mono<Boolean> randomVoted() {
        return Mono.just(upvoteService.randomVoted());
    }

}

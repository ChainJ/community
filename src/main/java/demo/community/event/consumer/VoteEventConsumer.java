package demo.community.event.consumer;

import demo.community.entity.Upvote;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : JiangCheng
 * @date : 2021/8/31 5:37 下午
 */
@Component
public class VoteEventConsumer {

//    @KafkaListener(topics = "demo:community:vote", concurrency = "4")
    public void consumeVoteMessage(String message){
//        Upvote upvote =
    }

}

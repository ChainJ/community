package demo.community.service;

import demo.community.dal.UpvoteRepository;
import demo.community.entity.Upvote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

/**
 * @author : JiangCheng
 * @date : 2021/8/27 6:09 下午
 */
@Service
public class UpvoteService {
    Random random = new Random();

    @Autowired
    UpvoteRepository upvoteRepository;

    public boolean randomUpvote() {
        Upvote upvote = Upvote.builder()
                .topicId((long) random.nextInt(10_000))
                .userId((long) random.nextInt(100_000) + 40000)
                .votedAt(LocalDateTime.now())
                .build();
        return upvote(upvote);
    }

    public long randomCount() {
        return count(random.nextInt(10_000));
    }

    public boolean randomVoted() {
        Upvote upvote = Upvote.builder()
                .topicId((long) random.nextInt(10_000))
                .userId((long) random.nextInt(100_000))
                .votedAt(LocalDateTime.now())
                .build();
        return upVoted(upvote);
    }

    public boolean upvote(Upvote upvote) {
        return upvoteRepository.add(upvote);
    }

    public boolean downVote(Upvote upvote) {
        return upvoteRepository.remove(upvote.getTopicId(), upvote.getUserId());
    }

    public boolean upVoted(Upvote upvote) {
        return Objects.nonNull(upvoteRepository.score(upvote.getTopicId(), upvote.getUserId()));
    }

    public long count(long topicId) {
        return upvoteRepository.count(topicId);
    }

}

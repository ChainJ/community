package demo.community.dal;

import demo.community.entity.Upvote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.ZoneOffset;
import java.util.Optional;

/**
 * @author : JiangCheng
 * @date : 2021/8/27 6:26 下午
 */
@Repository
public class UpvoteRepository {
    static private final String UPVOTE_PREFIX = "demo.community:upvote:";

    static boolean useMysql = false;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    UpvoteMysqlDAO upvoteMysqlDAO;

    public long count(long topicId) {
        if (useMysql) {
            return upvoteMysqlDAO.count(Example.of(Upvote.builder().topicId(topicId).build()));
        }
        return Optional.ofNullable(redisTemplate.opsForZSet().zCard(UPVOTE_PREFIX + topicId)).orElse(0L);
    }

    public Double score(long topicId, long userId) {
        if (useMysql) {
            return upvoteMysqlDAO.findOne(Example.of(Upvote.builder().topicId(topicId).userId(userId).build()))
                    .map(upvote -> (double) upvote.getVotedAt().toEpochSecond(ZoneOffset.ofHours(8)))
                    .orElse(0d);
        }
        return redisTemplate.opsForZSet().score(UPVOTE_PREFIX + topicId, userId);
    }

    public boolean add(Upvote upvote) {
        if (useMysql) {
            try {
                upvoteMysqlDAO.save(upvote);
                return true;
            } catch (DuplicateKeyException e) {
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return Boolean.TRUE.equals(redisTemplate.opsForZSet().add(UPVOTE_PREFIX + upvote.getTopicId(),
                upvote.getUserId().toString(), upvote.getVotedAt().toEpochSecond(ZoneOffset.ofHours(8))));
    }

    public boolean remove(long topicId, long userId) {
        if (useMysql) {
            upvoteMysqlDAO.delete(Upvote.builder().topicId(topicId).userId(userId).build());
            return true;
        }
        return Optional.ofNullable(redisTemplate.opsForZSet().remove(UPVOTE_PREFIX + topicId, userId))
                .map(count -> count == 1)
                .orElse(false);
    }

}

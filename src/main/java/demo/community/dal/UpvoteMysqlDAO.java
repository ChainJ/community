package demo.community.dal;

import demo.community.entity.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : JiangCheng
 * @date : 2021/8/28 4:51 下午
 */
public interface UpvoteMysqlDAO extends JpaRepository<Upvote, Long> {
}

package demo.community.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : JiangCheng
 * @date : 2021/8/27 6:01 下午
 */
@Entity
@Table(name = "upvote")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Upvote {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 主题ID
     */
    Long topicId;
    /**
     * 用户ID
     */
    Long userId;
    /**
     * 点赞时间
     */
    LocalDateTime votedAt;
}

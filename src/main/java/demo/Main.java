package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : JiangCheng
 * @date : 2021/8/27 9:32 下午
 */
@SpringBootApplication
@EnableAutoConfiguration//(exclude = DataSourceAutoConfiguration.class)
public class Main {
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}

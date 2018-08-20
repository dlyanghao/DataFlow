package work.yanghao.dataflow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@MapperScan("work.yanghao.dataflow.mapper")
public class DataflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataflowApplication.class, args);
    }
}

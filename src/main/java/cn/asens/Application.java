package cn.asens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

/**
 * @author Asens
 * create 2019-01-17 12:04
 **/


@EntityScan(basePackages = "cn.asens.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class, scanBasePackages="cn.asens")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}

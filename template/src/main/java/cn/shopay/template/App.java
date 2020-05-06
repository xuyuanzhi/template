package cn.shopay.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description springboot启动类
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
@SpringBootApplication
@ComponentScan(basePackages = { "cn.shopay.template"})
@MapperScan("cn.shopay.template.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

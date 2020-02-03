package com.zdw;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages="com.zdw")
public class BaiduUidGeneratorJpaApplication {

    @Bean
    public DataSource createDataSource(){
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://192.168.163.111:3306/vipdb?characterEncoding=utf8");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("admin321");
        return ds;
    }

    public static void main(String[] args) {
        SpringApplication.run(BaiduUidGeneratorJpaApplication.class, args);
    }
}

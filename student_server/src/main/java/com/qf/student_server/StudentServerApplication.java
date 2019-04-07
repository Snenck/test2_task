package com.qf.student_server;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
@DubboComponentScan("com.qf.service")
public class StudentServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServerApplication.class, args);
	}

}

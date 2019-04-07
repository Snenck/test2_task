package com.qf.tclass_server;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
@DubboComponentScan("com.qf.service")
public class TclassServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TclassServerApplication.class, args);
	}

}

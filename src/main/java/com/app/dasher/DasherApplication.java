package com.app.dasher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Paly
 * @version 1.0
 * @date 03/11/22 12:47 pm
 * @company NextUp
 */
@EnableScheduling
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DasherApplication {

  public static void main(String[] args) {
    SpringApplication.run(DasherApplication.class, args);
  }

}

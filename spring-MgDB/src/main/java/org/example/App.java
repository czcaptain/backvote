package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */


@SpringBootApplication
@Slf4j
public class App implements CommandLineRunner {



    @Autowired
    private StudentService studentService;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.insert();
        log.info("===================");
        studentService.queryStudent();
    }
}

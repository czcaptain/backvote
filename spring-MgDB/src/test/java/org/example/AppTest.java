package org.example;


import lombok.extern.slf4j.Slf4j;
import org.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple App.
 */
@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@Slf4j
public class AppTest {


    @Autowired
    private StudentService studentService;


    @Test
    public void test() {
        studentService.insert();
        log.info("==================");
        studentService.queryStudent();
    }


}

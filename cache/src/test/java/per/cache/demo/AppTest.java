package per.cache.demo;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Unit test for simple App.
 */


@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class AppTest{


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {

        long start = System.nanoTime();
        this.mockMvc.perform(get("/cache/products"));
        log.info("first select ====>{}",System.nanoTime() - start);






        long cacheStart = System.nanoTime();
        this.mockMvc.perform(get("/cache/products"));
        log.info("second select ====>{}",System.nanoTime() - cacheStart);

        log.info("student number ====>{}",this.mockMvc.perform(get("/cache/count")).andReturn().getResponse().getContentAsString());



        this.mockMvc.perform(get("/cache/delete/1"));

        long afterDelete = System.nanoTime();
        this.mockMvc.perform(get("/cache/products"));
        log.info("select after delete ====>{}",System.nanoTime() - afterDelete);

        log.info("student number ====>{}",this.mockMvc.perform(get("/cache/count")).andReturn().getResponse().getContentAsString());


    }



}

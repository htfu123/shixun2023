package com.bjtu;

import com.bjtu.domain.Cargo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class UserServerApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private RestTemplate restTemplate1;

    @Test
    void contextLoads() {
    }

    @Test
    void TestRestTemplate(){
        String url = "http://cargoserver/cargo/list";
        Cargo cargo = restTemplate.getForObject(url, Cargo.class);
        System.out.println(cargo);
    }

//    @Test
//    void TestRestTemplate1(){
//        String url = "http://localhost:8080/cargo/list";
//        Cargo cargo = restTemplate1.getForObject(url, Cargo.class);
//        System.out.println(cargo);
//    }

}

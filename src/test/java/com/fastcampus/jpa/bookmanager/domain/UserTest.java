package com.fastcampus.jpa.bookmanager.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

@Slf4j
class UserTest {

    @Test
    void Test() {
        // User user1 = new User(null,"martin", "martin@fastcampus", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("martin", "martin@fastcampus");
        User user3 = User.builder()
                .id(null)
                .name("martin")
                .email("martin@fastcampus.com")
                .build();

       // System.out.printf(">>> " + user1.toString());
        System.out.printf(">>> " + user2.toString());
        System.out.printf(">>> " + user3.toString());
    }
}
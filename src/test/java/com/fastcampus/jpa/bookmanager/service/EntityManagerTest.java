package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityMangerTest() {

        userRepository.saveAndFlush(new User("martin", "martin@fastcampus.com"));
        userRepository.saveAndFlush(new User("karis", "karis@fastcampus.com"));
        userRepository.saveAndFlush(new User("lottin", "lottin@fastcampus.com"));
        userRepository.saveAndFlush(new User("rise", "rise@fastcampus.com"));
        userRepository.saveAndFlush(new User("martin", "martin131@fastcampus.com"));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");

        entityManager.createQuery("select u from User u").getResultList().forEach(System.out::println);  // userRepository.findAll() 과 동일
    }

    @Test
    void cacheFindTest() {
        userRepository.saveAndFlush(new User("martin", "martin@fastcampus.com"));

        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
        userRepository.findAll().forEach(System.out::println);
        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2() {
        userRepository.saveAndFlush(new User("martin", "martin@fastcampus.com"));
        var user = userRepository.findById(1L).get();
        user.setName("marrrrrrtin");
        userRepository.save(user);
        System.out.println("-------------------------------------");

        user.setEmail("marrtindssesesdsdee@fastcampus.com");
        userRepository.save(user);
        System.out.println(userRepository.findAll());

    }
}

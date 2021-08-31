package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() { // create, read, update, delete

        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.saveAndFlush(new User("new asdf", "asdf@ffs.com"));
        userRepository.saveAndFlush(new User("new sdfsd", "sdfsd@wer.com"));
        userRepository.saveAndFlush(new User("new werw", "werw@sdf.com"));
        userRepository.saveAndFlush(new User("new zxcvzxcv", "zxcvzxcv@se.com"));

        System.out.println("---------------------------------------------------------------------");


//      리스트 만들어 findAllbyId 하는 방법
//      List<User> users = userRepository.findAll(Sort.by("name"));
//      List<Long> ids = new ArrayList<>();
//      ids.add(1L);
//      ids.add(3L);
//      ids.add(5L);
//      List<User> users1 = userRepository.findAllById(Lists.newArrayList(1L, 2L, 3L));
//      users.forEach(System.out::println);

//      Lists.newArrayList 사용하여서 save All 하는 방법
//      User user1 = new User("jack", "jack@fastcampus.com");
//      User user2 = new User("steve", "steve@fastcampus.com");
//      userRepository.saveAll(Lists.newArrayList(user1, user2));
//      List<User> users = userRepository.findAll();
//      users.forEach(System.out::println);


//        User user1 = new User("jack", "jack@fastcampus.com");
//        User user2 = new User("steve", "steve@fastcampus.com");
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//
//        var user = userRepository.findById(1L).orElse(null);
//        System.out.println(user);

//
//        userRepository.findAll().forEach(System.out::println);

//        long count = userRepository.count();
//
//        System.out.println(count);

//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));

//        userRepository.deleteById(1L);

//
//        userRepository.deleteAllInBatch();
//
//        userRepository.findAll().forEach(System.out::println);

//        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
//
//        System.out.println("pages : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

//        var matchers = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//
//        var example = Example.of(new User("martin", "martin@fastcampus.com"), matchers);
//
//        userRepository.findAll(example).forEach(System.out::println);

//        var user = User.builder()
//                .name("karma")
//                .email("slow")
//                .build();
//
//        var matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        var example = Example.of(user, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        userRepository.save(new User("david", "david@fastcampus.com"));

        var user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select() {
        userRepository.saveAndFlush(new User(1L,"martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
        userRepository.saveAndFlush(new User(2L,"karis", "karis@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
        userRepository.saveAndFlush(new User(3L,"lottin", "lottin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
        userRepository.saveAndFlush(new User(4L,"rise", "rise@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
        userRepository.saveAndFlush(new User(5L,"martin", "martin131@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));

        System.out.println("---------------------------------------------------------------------");

        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));


        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));

    }
}
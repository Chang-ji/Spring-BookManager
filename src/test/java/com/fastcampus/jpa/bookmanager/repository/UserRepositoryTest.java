package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

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

        var user = userRepository.findByName("david");
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select() {
//        userRepository.saveAndFlush(new User(1L,"martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(2L,"karis", "karis@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(3L,"lottin", "lottin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(4L,"rise", "rise@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(5L,"martin", "martin131@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");

// 쿼리 메소드 기본 실습 1 find, get, read, query, search, stream, findBy, findTop, findFirst
//        System.out.println(userRepository.findByName("dennis"));
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
//        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));

// Equal이 포함이 됐느지 않됬지는 가 중요함
// Before, After는 쿼리 문에서 Equal을 포함하지 않음
// Between 양끝단의 값을 포함하고 있음
// 쿼리 메소드 기본실습 2 findByEmailAndName, findByEmailOrName
//        System.out.println("findFirst2ByName : " + userRepository.findByEmailAndName("martin@fastcampus.com","martin"));
//        System.out.println("findFirst2ByName : " + userRepository.findByEmailOrName("karis@fastcampus.com","martin"));
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
// NotEmpty 정보 여부 중요
//        System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());
//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "karis")));
// Like 부분이 작동됨
//        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("martin"));
//        System.out.println("---------------------------------------------------------------------");
//        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
//        System.out.println("---------------------------------------------------------------------");
//        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));
// Like 검색을 할때 %art% 처럼 단방향, 양방향으로 검색할 수 있음
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%art%"));

    }

    @Test
    void pagingAndsortingTest() {
//        userRepository.saveAndFlush(new User(1L,"martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(2L,"karis", "karis@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(3L,"lottin", "lottin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(4L,"rise", "rise@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));
//        userRepository.saveAndFlush(new User(5L,"martin", "martin131@fastcampus.com", LocalDateTime.now(), LocalDateTime.now()));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");


//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
//        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("martin"));
//        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
//  Sort 부분 Naming 기반으로 코딩할 것인지 파라미터 기반으로 코딩할 것인지 결정
//        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", getSort()));

        // 페이지 기반 쿼리메소드 getTotalElements, getContent 값을 사용
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());

    }

    private Sort getSort() {
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.desc("email"),
                Sort.Order.desc("createdAt")
        );
    }

    @Test
    void insertAndUpdateTest() throws Exception {


        User user = new User();
        user.setName("martin");
        user.setEmail("martin@fastcampus.com");
        userRepository.save(user);

        var user2 = userRepository.findById(1L).orElseThrow(Exception::new);
        user2.setName("marrrtint");
        userRepository.save(user2);

    }

    @Test
    void enumTest() {
        userRepository .saveAndFlush(new User("martin", "martin@fastcampus.com"));
        userRepository.saveAndFlush(new User("karis", "karis@fastcampus.com"));
        userRepository.saveAndFlush(new User("lottin", "lottin@fastcampus.com"));
        userRepository.saveAndFlush(new User("rise", "rise@fastcampus.com"));
        userRepository.saveAndFlush(new User("martin", "martin131@fastcampus.com"));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");


        var user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marttinss");
        userRepository.save(user2);

        userRepository.findAll().forEach(System.out::println);

    }

    @Test
    void prePersisTest() throws Exception {

        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findById(3L).orElseThrow(Exception::new));
    }

    @Test
    void preUpdateTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findById(1L));

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");

        var user2 = userRepository.findById(2L).orElseThrow(RuntimeException::new);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");

        user2.setName("marttinss");

        userRepository.save(user2);

        System.out.println(userRepository.findByName("marttinss"));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");
        userRepository.save(user);

        user.setName("martin-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("daivid");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);

        user.setName("daniel");

        userRepository.save(user);

        user.setEmail("danial@fastcampus.com");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("danial@fastcampus.com").getId()
//        );

        List<UserHistory> result = userRepository.findByEmail("danial@fastcampus.com").getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }
}
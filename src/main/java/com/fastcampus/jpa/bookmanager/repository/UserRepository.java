package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    // 쿼리 메소드 1 실습
    Set<User> findByName(String name);
    User findByEmail(String email);
    User getByEmail(String email);
    User readByEmail(String email);
    User queryByEmail(String email);
    User searchByEmail(String email);
    User streamByEmail(String email);
    User findUserByEmail(String email);
    User findSomethingByEmail(String email);
    List<User> findFirst2ByName(String name);
    List<User> findTop2ByName(String name);

    // 쿼리 메소드 2 실습
    List<User> findByEmailAndName(String email, String name);
    List<User> findByEmailOrName(String email, String name);
    List<User> findByCreatedAtAfter(LocalDateTime yesterday);
    List<User> findByIdAfter(Long id);
    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<User> findByIdBetween(Long id1, Long id2);
    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);
    List<User> findByIdIsNotNull();
//    List<User> findByAddressIsNotEmpty(); // name is not null and name !='' ??
    List<User> findByNameIn(List<String> stringList);
    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContains(String name);
    List<User> findByNameLike(String name);
    Set<User> findUserByNameIs(String name);
    Set<User> findUserByName(String name);
    Set<User> findUserByNameEquals(String name);

    // 쿼리메소드 3
    List<User> findTop1ByName(String name);
    List<User> findLast1ByName(String name);
    List<User> findTop1ByNameOrderByIdDesc(String name);
    List<User> findTopByNameOrderByIdDesc(String name);
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);
    List<User> findFirstByName(String name, Sort sort);

    // 쿼리메소드 페이징 처리하기
    Page<User> findByName(String name, Pageable pageable);






}

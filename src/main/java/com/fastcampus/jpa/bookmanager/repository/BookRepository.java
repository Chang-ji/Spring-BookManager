package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.BookReviewInfo;
import com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);

    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    List<Book> findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

    // 파라미터 순서에 영향을 받지 않기 때문 sideEffect에 자유롭고 코드 수정이 더 편하다. 파라미터 매핑 방식을 사용하자.
    @Query(value = "select b from Book b "
            + "where name = :name and createdAt >= :createdAt and updatedAt >= :updatedAt and category is null")
    List<Book> findByNameRecently(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt
    );

    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b ")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b ")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);

    // 성능애 대한 문제를 해결하기 위해 많이 사용된다.
    // native 에서는 @where 값이 없고 db에서 사용하는 sql 문을 그대로 실행된다.
    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAllCustom();

    @Transactional
    @Modifying
    @Query(value = "update book set category = 'IT전문서'", nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();
}

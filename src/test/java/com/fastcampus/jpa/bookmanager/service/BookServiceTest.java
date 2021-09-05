package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Isolation;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest() {
        try {
            bookService.putBoookAndAuthor();
        } catch (RuntimeException e) {
            System.out.println(">>> " + e.getMessage());
        }

        System.out.println("books" + bookRepository.findAll());
        System.out.println("authors" + authorRepository.findAll());

    }

    // Isolation.SERIALIZABLE commit 실행되어야만 추가적인 로직이 실행할 수 있다.
    // 차례대로 Transaction이 끝나야 실행한다. 속도가 느린 대신에 정확하다.

    // Transaction isolation 단계에 따라서 다르게 반응한다.
    // Isolation.REPEATABLE_READ MySQL 의 기본 Isolation 단계 Transaction 완료 될때까지 DB에 반영되지 않는다.
    // Isolation.REPEATABLE_READ 트랜잭션 내에서 조회할 경우에는 값이 바뀌지 않는다.
    // 트랜잭션이 종료된 후에서 변경된다.
    // 트랜잭션 내에서 insert 가 된 경우에는 원래 data 뿐 아니라 insert된 데이터 까지 update 되는 경우가 발생한다. 센텀리드 상황이 발생한다.

    // Isolation.READ_UNCOMMITTED 단계에서는 commit 되지 않아도 읽을 수 있다. @DynamicUpdate 를 이용하여 해결할 수 있다. 필요한 정보만 업데이트 한다.
    // DutyRead가 발생하여서 데이터의 정확성을 낮출수 있다.

    // Isolation.READ_COMMITTED @DynamicUpdate사용하지 않아도 DutyRead가 발생하지 않는다.
    // 내가 생성한 트랜잭션 내에서 반복적으로 조회했는데 중간에 바뀌는 현상이 발생한다. 트랜잭션 내에서 값이 달라질 수 있다는 것이다.
    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("JPA 시작하기");
        bookRepository.save(book);

        bookService.get(1L);
        System.out.println(">>> " + bookRepository.findAll());
    }


}
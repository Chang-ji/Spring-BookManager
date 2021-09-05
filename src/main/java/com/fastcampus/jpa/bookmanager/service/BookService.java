package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

    // 같은 클래스 내에서 함수를 호출하면 @Transcational 이라는 어노테이션이 읽히지 않는다.
    // 같은 빈클래스 내에서 호출하면 어노테이션이 읽히지 않는다.
    public void put() {
        this.putBoookAndAuthor();
    }

    // RutimeException 이 발생될 경우 Transaction 이 반영되지 않고 Rollback
    // Exception 이 발생될 경우에는 Transaction 이 반영됨 Rollback 이 되지 않음
    @Transactional(propagation = Propagation.REQUIRED)
    public void putBoookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        try {
            authorService.putAuthor();
        } catch (RuntimeException e) {
        }

//        throw new RuntimeException("오류가 발생하였습니다. transaction은 어떻게 될까요?");
//
//        Author author = new Author();
//        author.setName("martin");
//
//        authorRepository.save(author);
//
//        throw new RuntimeException("오류가 나서 DB commit이 발생하지 않았습니다.");
    }

    // Propagation.REQUIRED Transaction 있다면 사용하고 그렇치 않다면 생성해준다. save() Transaction 의 기본값

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(long id) {
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();

//        Book book = bookRepository.findById(1L).get();
//        book.setName("빠뀔까?");
//        bookRepository.save(book);
    }
}

package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.*;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewReporsitory reviewReporsitory;
    @Autowired
    private UserRepository userRepository;


    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("Jpa 초격차 패키지");
        book.setAuthorId(1L);
        // book.setPublisherId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();
        userRepository.findUserByEmail("david@fastcampus.com").setReviews(reviewReporsitory.findAll());
        User user = userRepository.findUserByEmail("david@fastcampus.com");
        System.out.println("Review : " + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());

    }

    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
//        bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");
//        publisherRepository.save(publisher);

        book.setPublisher(publisher);
        bookRepository.save(book);

//        publisher.addBook(book);
//        publisherRepository.save(publisher);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publisher : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우 캠퍼스");
        bookRepository.save(book1);

        System.out.println("publishers : " + publisherRepository.findAll());

//        Book book2 = bookRepository.findById(1L).get();
//        bookRepository.delete(book2);

        Book book3 = bookRepository.findById(1L).get();
        book3.setPublisher(null);
        bookRepository.save(book3);


        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());
        System.out.println("book3 publisher : " + bookRepository.findById(1L).get().getPublisher());

    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);
        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));
        bookRepository.findAllByDeletedFalse().forEach(System.out::println);
        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
        bookRepository.findAll().forEach(System.out::println);
    }

    @Test
    void queryTest() {
        System.out.println("findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual: " +
                bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
                        "JPA 초격차 패키지",
                        LocalDateTime.now().minusDays(1L),
                        LocalDateTime.now().minusDays(1L)
                ));
        System.out.println("findByNameRecently : " +
                bookRepository.findByNameRecently(
                        "JPA 초격차 패키지",
                        LocalDateTime.now().minusDays(1L),
                        LocalDateTime.now().minusDays(1L)
                ));
        bookRepository.findBookNameAndCategory().forEach(b -> {
            System.out.println(b.getName() + " : " + b.getCategory());
        });
        bookRepository.findBookNameAndCategory(PageRequest.of(1, 1));
    }

    @Test
    void nativeQueryTest() {
//        bookRepository.findAll().forEach(System.out::println);
//        bookRepository.findAllCustom().forEach(System.out::println);
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            book.setCategory("IT전문서");
        }
        bookRepository.saveAll(books);
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("affedcted rows : " + bookRepository.updateCategories());
        System.out.println(bookRepository.showTables());
    }

    private void givenBookAndReview() {
        givenReview(givenUser(),givenBook(givenPublisher()));
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("패스트 캠퍼스");

        return publisherRepository.save(publisher);
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 초격차 패키지");
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    private User givenUser() {
        User user = new User();
        user.setName("daivid");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);


        userRepository.save(user);

        return userRepository.findByEmail("david@fastcampus.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이었어요.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewReporsitory.save(review);
    }
}
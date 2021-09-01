package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

//    private Long bookId;

    @OneToOne(optional = false)
    private Book book;

    //평점과 리뷰 수에 Null 인것에 따라서 Type 고르기 Float vs float, Integer vs int
    private float averageReviewScore;

    private int reviewCount;
}

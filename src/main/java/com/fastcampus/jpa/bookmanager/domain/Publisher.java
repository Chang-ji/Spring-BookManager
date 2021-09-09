package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Publisher extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // 연관관계를 null 변경하면 연관관계가 끊어진다. 이때 orphanRemoval을 true 설정하면 db에서 연관관계 끊어지기 전 값들도 다 제거된다.
    @OneToMany(orphanRemoval = false)
    @JoinColumn(name="publisher_id")
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();



    public void addBook(Book book) {
        this.books.add(book);
    }


}

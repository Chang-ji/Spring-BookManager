# Spring-BookManager
## 데이터 베이스 접속
1. http://localhost:8070/h2-console 접속
2. url 값에 Database available at 'jdbc:h2:mem:1f6c1a02-6cba-4923-ba43-0e5578b1a81f' 입력

### @Colum
- updatable 과 insertable 을 false 로 설정하면 그 컬럼의 값은 update, insert 쿼리가 생성되지 않는다.
- @Transient 사용하면 영속성 처리에 제외되기 때문에 DB에 반영되지 않는다.

### Enum을 사용하는 경우 value=EnumType.STRING 으로 지정하여 잠재적 오류를 예방하자


### 4. Entitiy Listener 의 활용
> 1. @PrePersist
> 2. @PreUpdate
> 3. @PreRemove
> 4. @PostUpdate
> 5. @PostRemove
> 6. @PostLoad
> 7. @EntityListeners
> 8. @EnableJpaAuditing
> 9. @CreatedDate
> 10. @LastModifiedDate
> 11. AuditingEntityListener.class
> 12. @MappedSuperclass

### 5. 연관관계 살펴보기
> 1. @OneToOne
> 2. @OneToMany
> 3. @JoinColumn(name = "user_id", insertable = false, updatable = false)

    
    
    
    
    
    
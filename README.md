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

### 6. 트랜잭션
1. Checked Exception, UnChecked Exception 에서는 Checked Exception 일 때 트랜잭션이 반영되지만 UnChecked Exception 일 때 반영하지 않는다.
> Checked EXception 일 경우 개발자가 더 세세하게 생각해서 구현해야한다. 나도 모르게 트랜잭션이 발생함
> rollbarFor 를 사용하여 해당하는 예외 부분을 적용할 수 있음
2. 같은 클래스 내에서 함수의 호출 하면 트랜잭션이 작동하지 않는다.
> 같은 Spring Bean 에서 호출 될 경우에 어노테이션 같이 작동하지 않아서 @Transactional 값이 있더

    
    
    
    
    
    
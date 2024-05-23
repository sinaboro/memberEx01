<h1>Member Proejct</h1># memberEx01

<h2>1. DB설정(mysql) </h2>

```db
create database member default character set utf8 collate utf8_general_ci;
```

<h2>2. 프로젝트 설정 </h2>

<h3>1</h3>
<img src="/images/start01.PNG">
<h3>2</h3>
<img src="/images/start02.PNG">
<h3>3</h3>
<img src="/images/start03.PNG">

<h3>application.properties 추가</h3>

```java
#MySQL 설정
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/member?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=1234
```

<h3>4</h3>
<img src="/images/start04.PNG">
<h3>5</h3>
<img src="/images/start05.PNG">
<h3>6</h3>
<img src="/images/start06.PNG">

<h3>7 프로젝트 폴더 및 파일 생성</h3>
<img src="/images/start07.PNG">

<h2>3. 코드 구현 </h2>

<h4>1. entity 폴더 Member</h4>

```java
package com.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;

    private String phone;
    private String address;

}

```

<h4>2. 생성된 DB를 mysql 확인</h4>
<img src="/images/start08.PNG">

<h4>3. repository -> MemberRepository </h4>

```java
package com.member.repository;

import com.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

```
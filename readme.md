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


<h2>4. CRUD 구현 </h2>

<h4>1. repository -> MemberRepository </h4>

```java
package com.member.repository;

import com.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

```

<h4>2. lombok 추가</h4>
<img src="/images/start09.PNG">

<h6>build.gradle  추가하면됨</h6>
<img src="/images/start10.PNG">
<br>


<h4>3. service - > MemberService</h4>

```java
package com.member.service;

import com.member.entity.Member;
import com.member.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

		//CRUD => Create
    public void register(Member member){
        memberRepository.save(member);
    }
}

```

<h4>4. build.gradle -> lombok test환경 추가</h4>

```xml
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'

    testCompileOnly 'org.projectlombok:lombok'
    testAnnotationProcessor 'org.projectlombok:lombok'
```

<h4>5. MemberServiceTest 추가</h4>

<img src="/images/start11.PNG">
<img src="/images/start12.PNG">
<img src="/images/start13.PNG">

```java
package com.member.service;

import com.member.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@Log4j2
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testInsert(){
        Member member = new Member();
        member.setAge(20);
        member.setName("까미");
        member.setAddress("수원시");

        memberService.register(member);

    }
}
```

<h4>5. 실행 및 mysql 추가 확인</h4>
<img src="/images/start14.PNG">
<img src="/images/start15.PNG">

<h4>5. CRUD -> update</h4>

```java
  class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    //CRUD -> update
    @Test
    public void testupdate(){
        Member member = new Member();
        member.setId(1L);
        member.setAge(28);
        member.setName("까미");
        member.setAddress("안산시");

        memberService.register(member);
    }
```

<img src="/images/start16.PNG">
<img src="/images/start18.PNG">
<img src="/images/start17.PNG">

<h4>5. CRUD -> read</h4>

```java
public class MemberService {

    private final MemberRepository memberRepository;

    //CRUD => Create,Update
    public void register(Member member){
        memberRepository.save(member);
    }

```

```java
@SpringBootTest
@Log4j2
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    //CRUD -> read
    @Test
    public void testRead(){
        Long memberId = 1L;

        Member team = memberService.read(memberId);
        log.info("team : " + team);
    }
```
<img src="/images/start19.PNG">
<img src="/images/start20.PNG">
<img src="/images/start21.PNG">

<h4>5. CRUD -> read All(전체데이타가져오기)</h4>

```java
public class MemberService {

    private final MemberRepository memberRepository;

    //CRUD => Read All
    public List<Member> readAll(){

        List<Member> members = memberRepository.findAll();
        return members;
    }
```

```java
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    //CRUD -> read All
    @Test
    public void testReadAll(){

        List<Member> members = memberService.readAll();
        members.forEach(member -> log.info(member));
    }
```

<img src="/images/start22.PNG">
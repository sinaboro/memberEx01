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

    //CRUD -> read
    @Test
    public void testRead(){
        Long memberId = 1L;

        Member team = memberService.read(memberId);
        log.info("team : " + team);
    }

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

    //CRUD -> create
    @Test
    public void testInsert(){
        Member member = new Member();
        member.setAge(20);
        member.setName("까미");
        member.setAddress("수원시");

        memberService.register(member);
    }


}
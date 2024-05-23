package com.member.controller;

import com.member.entity.Member;
import com.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j2
public class MemberContoller {

    private final MemberService memberService;

    @GetMapping("/list")
    public String list(Model model){
        List<Member> members = memberService.readAll();
        model.addAttribute("members", members);
        log.info(members);
        return "member/list";

    }
    @GetMapping("/new")
    public String createForm(Model model){
        log.info("create.............");
        model.addAttribute("member", new Member());
        return "member/newForm";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("member") Member member){
        log.info("------------------------");
        memberService.register(member);
        return "redirect:list";
    }

    // <a th:href="@{/member/edit/{id}(id=${member.id})}">수정</a>&nbsp;&nbsp;

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") String id,Model model){
        Long memberId = Long.parseLong(id);
        Member member = memberService.read(memberId);
        model.addAttribute("member", member);
        return "member/updateForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Member member){
       log.info("update..........." + member);
        memberService.register(member);
        return "redirect:list";
    }

}

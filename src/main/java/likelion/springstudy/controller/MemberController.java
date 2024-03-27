package likelion.springstudy.controller;


import likelion.springstudy.domain.Address;
import likelion.springstudy.domain.Member;
import likelion.springstudy.dto.MemberForm;
import likelion.springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService = new MemberService();

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String join(MemberForm memberForm) {
        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());
        Member member = new Member(memberForm.getName(), address);
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String findAll(Model model) {

        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}

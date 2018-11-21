package examples.boot.malljpa.controller;

import examples.boot.malljpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "members/login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "members/signup";
    }

//    @PostMapping("/signup")
//    public String signupAction(){
//    }
}

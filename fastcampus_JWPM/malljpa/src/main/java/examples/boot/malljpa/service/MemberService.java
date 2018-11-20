package examples.boot.malljpa.service;

import examples.boot.malljpa.domain.Member;

public interface MemberService {
    public Member getMember(String email);
}

package examples.boot.malljpa.service;

import examples.boot.malljpa.domain.Member;
import examples.boot.malljpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public Member getMember(String email) {
        return memberRepository.getMember(email);
    }
}

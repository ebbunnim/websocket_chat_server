package ebbunnim.chatserver.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import ebbunnim.chatserver.domain.Member;
import ebbunnim.chatserver.repository.MemberRepository;
import ebbunnim.chatserver.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // service에서 repository constructor에서 명시한대로 "외부에서 주입받겠다"를 사용. 독립된 인스턴스 생성되지 않도록.
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("지영1");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("지영1");

        Member member2 = new Member();
        member2.setName("지영1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // try-catch보단 다음 방식 선호
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void 회원찾기() {
    }

    @Test
    void findOne() {
    }
}
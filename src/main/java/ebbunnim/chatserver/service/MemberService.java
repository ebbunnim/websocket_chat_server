package ebbunnim.chatserver.service;

import ebbunnim.chatserver.domain.Member;
import ebbunnim.chatserver.repository.MemberRepository;
import ebbunnim.chatserver.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { // DI(dependency Injection) : "외부에서 주입받겠다"
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X 로직 추가
        // null일 가능성이 있으면 Optional로 감싸서 반환을 해줌(.get()으로 직접 꺼내는 걸 권장하지 않음) -> ifPresent 사용 가능
        // Optional 앞에 쓰여있지 않아도 되도록 바로 ifPresent로 체크해버리는 것 권장 => validateDuplicateMember method로 extract해버렸음
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}

package ebbunnim.chatserver.repository;

import ebbunnim.chatserver.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // test가 끝날때마다 저장소를 clear함 (테스트가 서로 의존관계 없이 실행되도록) **
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // save -> findById 해보기
        Member member = new Member();
        member.setName("ebbunnim");

        repository.save(member);
        Member result = repository.findById(member.getId()).get(); //Optional로 get으로 꺼내는데, test아니었으면 좋은 방법은 아니다.
//        System.out.println("result"+(result.equals(member)));
        Assertions.assertThat(member).isEqualTo(result); //검증
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("지영1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("지영2");
        repository.save(member2);

        Member result = repository.findByName("지영2").get();
        Assertions.assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findByAll() {
        Member member1 = new Member();
        member1.setName("지영1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("지영2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);

    }

}

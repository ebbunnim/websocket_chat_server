package ebbunnim.chatserver;

import ebbunnim.chatserver.domain.Member;
import ebbunnim.chatserver.repository.JdbcTemplateMemberRepository;
import ebbunnim.chatserver.repository.JpaMemberRepository;
import ebbunnim.chatserver.repository.MemberRepository;
import ebbunnim.chatserver.repository.MemoryMemberRepository;
import ebbunnim.chatserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }
}

package ebbunnim.chatserver;

import ebbunnim.chatserver.repository.JdbcTemplateMemberRepository;
import ebbunnim.chatserver.repository.MemberRepository;
import ebbunnim.chatserver.repository.MemoryMemberRepository;
import ebbunnim.chatserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}

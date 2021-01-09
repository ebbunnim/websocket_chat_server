package ebbunnim.chatserver;

import ebbunnim.chatserver.repository.ChatRoomRepository;
import ebbunnim.chatserver.repository.JpaChatRoomRepository;
import ebbunnim.chatserver.repository.JpaMemberRepository;
import ebbunnim.chatserver.repository.MemberRepository;
import ebbunnim.chatserver.service.ChatRoomService;
import ebbunnim.chatserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public ChatRoomService chatRoomService() {
        return new ChatRoomService(chatRoomRepository());
    }

    @Bean
    public ChatRoomRepository chatRoomRepository() {
        return new JpaChatRoomRepository(em);
    }
}

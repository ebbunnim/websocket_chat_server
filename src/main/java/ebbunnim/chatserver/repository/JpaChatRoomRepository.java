package ebbunnim.chatserver.repository;

import ebbunnim.chatserver.domain.ChatRoom;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaChatRoomRepository implements ChatRoomRepository {

    private final EntityManager em;

    public JpaChatRoomRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public ChatRoom save(ChatRoom chatRoom) {
        em.persist(chatRoom);
        return chatRoom;
    }

    @Override
    public Optional<ChatRoom> findById(Long id) {
        ChatRoom chatRoom = em.find(ChatRoom.class, id);
        return Optional.ofNullable(chatRoom);
    }

    @Override
    public Optional<ChatRoom> findByName(String name) {
        return em.createQuery("select c from ChatRoom c", ChatRoom.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public List<ChatRoom> findAll() {
        return em.createQuery("select c from ChatRoom c", ChatRoom.class)
                .getResultList();
    }

}

package ebbunnim.chatserver.repository;

import ebbunnim.chatserver.domain.ChatRoom;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository {
    ChatRoom save(ChatRoom chatRoom);
    Optional<ChatRoom> findById(Long id);
    Optional<ChatRoom> findByName(String name);
    List<ChatRoom> findAll();
}

package ebbunnim.chatserver.service;

import ebbunnim.chatserver.domain.ChatRoom;
import ebbunnim.chatserver.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public Long createRoom(ChatRoom chatRoom) {
        // validate Duplicate
        validateDuplicateRoomName(chatRoom);
        chatRoomRepository.save(chatRoom);
        return chatRoom.getRoomId();
    }

    public Optional<ChatRoom> findById(Long id){
        return chatRoomRepository.findById(id);
    }

    public Optional<ChatRoom> findByName(String name) {
        return chatRoomRepository.findByName(name);
    }

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    private void validateDuplicateRoomName(ChatRoom chatRoom) {
        chatRoomRepository.findByName(chatRoom.getName()).ifPresent(m -> {
            throw new IllegalStateException("같은 이름의 채팅방이 이미 존재합니다.");
        });
    }


}

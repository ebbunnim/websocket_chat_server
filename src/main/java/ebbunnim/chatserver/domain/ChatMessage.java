package ebbunnim.chatserver.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Getter
@Setter
@EnableWebSocketMessageBroker
public class ChatMessage {

    private Long roomId;
    private String sender;
    private String message;
    private MessageType type;

    public enum MessageType {
        ENTER, TALK
    }
}

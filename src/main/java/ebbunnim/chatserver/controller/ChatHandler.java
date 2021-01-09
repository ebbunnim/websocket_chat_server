//package ebbunnim.chatserver.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import ebbunnim.chatserver.service.ChatRoomService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//
//@Slf4j
//@Component
//public class ChatHandler extends TextWebSocketHandler {
//
//    private final ObjectMapper objectMapper;
//    private final ChatRoomService chatService;
//
//    @Autowired
//    public ChatHandler(ObjectMapper objectMapper, ChatRoomService chatService) {
//        this.objectMapper = objectMapper;
//        this.chatService = chatService;
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
////        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//
//    }
//}

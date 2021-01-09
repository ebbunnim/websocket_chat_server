package ebbunnim.chatserver.controller;


import ebbunnim.chatserver.domain.ChatRoom;
import ebbunnim.chatserver.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("/chat/room")
    public String room() {
        System.out.println("chat room!");
        return "chat/room";
    }

    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<ChatRoom> rooms() {
        return chatRoomService.findAll();
    }

    @PostMapping("/chat/room")
    @ResponseBody
    public Long createRoom(@RequestParam String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        return chatRoomService.createRoom(chatRoom);
    }

    @GetMapping("/chat/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable Long roomId) {
        model.addAttribute("roomId", roomId);
        return "chat/roomdetail";
    }

    @GetMapping("/chat/room/{roomId}")
    @ResponseBody
    public Optional<ChatRoom> roomInfo(@PathVariable Long roomId) {
        return chatRoomService.findById(roomId);
    }

}

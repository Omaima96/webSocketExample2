package co.develhope.webSocketExample2.controllers;

import co.develhope.webSocketExample2.entities.MessageDTO;
import co.develhope.webSocketExample2.entities.MessageFromClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController{
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClients(@RequestBody MessageDTO message){
        simpMessagingTemplate.convertAndSend("/topic/broadcast", message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/client-message") // /app/client-message
    @SendTo("/topic/broadcast")
    public MessageDTO handleMessageFromWebSocket(MessageFromClientDTO message){
        System.out.println("Arrived something on /app/client-message - " + message.toString());
        return new MessageDTO("Message from " + message.getClientName() ," - " + message.getClientAlert() ,
                " - " + message.getClientMessage());
    }
}

package co.develhope.webSocketExample2.entities;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MessageFromClientDTO {

    private String clientName;
    private String clientAlert;
    private String clientMessage;
}
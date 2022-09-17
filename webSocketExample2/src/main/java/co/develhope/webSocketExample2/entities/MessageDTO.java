package co.develhope.webSocketExample2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class MessageDTO {

        private String type;
        private String sender;
        private String message;

    }



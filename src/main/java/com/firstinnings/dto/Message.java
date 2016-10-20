package com.firstinnings.dto;

import lombok.Getter;

/**
 * Message object use to render the message overall.
 */
@Getter
public class Message {

    private String message;
    private String status;

    /**
     * C'tor.
     * @param message
     * @param status
     */
    public Message(String message, Status status) {
        this.message = message;
        this.status = status.name();
    }

    public static enum Status {
        INFO,
        ERROR,
        SUCCESS
    }

}

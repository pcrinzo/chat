package com.crud.chat.chat.expetion;

import java.util.Date;

public class ErrorDetails {

    private String details;
    private Date timestamp;
    private String message;

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getTimestamp() {
        return timestamp;
    }


    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }


}

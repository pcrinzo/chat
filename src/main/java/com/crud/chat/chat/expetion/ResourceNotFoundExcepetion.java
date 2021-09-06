package com.crud.chat.chat.expetion;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepetion extends Exception{

    private static final long serialVersionUID=1L;

    public ResourceNotFoundExcepetion(String message){
        super(message);
    }
}

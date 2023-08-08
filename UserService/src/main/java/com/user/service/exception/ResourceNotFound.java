package com.user.service.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(){
        super("Resource not found");
    }
    public ResourceNotFound(String message){
        super(message);
    }
}

package com.hsbc.socialnetwork.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PostMessageRequest {

    private static final int MESSAGE_MAX_LENGTH = 140;

    @Length(max = MESSAGE_MAX_LENGTH)
    @NotNull
    private String message;

    @NotNull
    private Long userId;

    public PostMessageRequest() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

package com.hsbc.socialnetwork.domain;


import javax.persistence.*;

@Entity(name = "Message")
public class MessageEntity extends BaseEntity {

    private String message;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public MessageEntity() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

package com.hsbc.socialnetwork.domain;

import javax.persistence.*;

@Entity(name = "Follow")
public class FollowEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "who_id")
    private UserEntity who;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "to_id")
    private UserEntity to;


    public FollowEntity() {
        super();
    }

    public UserEntity getWho() {
        return who;
    }

    public void setWho(UserEntity who) {
        this.who = who;
    }

    public UserEntity getTo() {
        return to;
    }

    public void setTo(UserEntity to) {
        this.to = to;
    }

}
